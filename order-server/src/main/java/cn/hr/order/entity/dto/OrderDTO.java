package cn.hr.order.entity.dto;

import cn.hr.order.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author fys2000
 * @date 2019/1/28 11:32
 * @description
 */
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    List<OrderDetail> orderDetails;
}
