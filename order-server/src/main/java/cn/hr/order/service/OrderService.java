package cn.hr.order.service;

import cn.hr.order.entity.dto.OrderDTO;

/**
 * @author fys2000
 * @date 2019/1/28 13:57
 * @description
 */
public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);
}
