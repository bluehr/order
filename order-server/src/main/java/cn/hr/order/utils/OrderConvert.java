package cn.hr.order.utils;

import cn.hr.order.entity.OrderForm;
import cn.hr.order.entity.dto.OrderDTO;

/**
 * @author fys2000
 * @date 2019/1/28 14:33
 * @description
 */
public class OrderConvert {
    public static OrderDTO convert2OrderDTO(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setOrderDetails(orderForm.getItems());
        return orderDTO;
    }
}
