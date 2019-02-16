package cn.hr.order.service.impl;

import cn.hr.order.dao.OrderDetailDao;
import cn.hr.order.dao.OrderMasterDao;
import cn.hr.order.entity.OrderDetail;
import cn.hr.order.entity.OrderMaster;
import cn.hr.order.entity.dto.OrderDTO;
import cn.hr.order.enums.OrderEnum;
import cn.hr.order.enums.PayEnum;
import cn.hr.order.service.OrderService;
import cn.hr.order.utils.UUIDUtil;
import cn.hr.product.client.ProductClient;
import cn.hr.product.common.DecreaseStockInput;
import cn.hr.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fys2000
 * @date 2019/1/28 13:57
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductClient productClient;
    @Autowired
    private OrderMasterDao orderMasterDao;
    @Autowired
    OrderDetailDao orderDetailDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public OrderDTO create(OrderDTO orderDTO) {
        List<OrderDetail> orderDetails = orderDTO.getOrderDetails();
        List<String> productIds = orderDetails.stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput> productInfos = productClient.listProductByIds(productIds);
        String masterID = UUIDUtil.getKey();
        BigDecimal orderAmount = new BigDecimal(0);
        for (OrderDetail orderDetail : orderDetails) {
            for (ProductInfoOutput productInfo : productInfos) {
                if (orderDetail.getProductId().equals(productInfo.getProductId())) {
                    orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(masterID);
                    orderDetail.setDetailId(UUIDUtil.getKey());
                    orderDetailDao.save(orderDetail);
                }
            }
        }
        //扣库存
        List<DecreaseStockInput> cartDTOS = orderDetails.stream().map(o -> new DecreaseStockInput(o.getProductId(), o.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDTOS);

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderDTO.setOrderId(masterID);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setPayStatus(PayEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderEnum.NEW.getCode());
        orderMaster.setOrderId(masterID);
        orderMasterDao.save(orderMaster);
        return orderDTO;
    }
}
