package cn.hr.order.dao;

import cn.hr.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fys2000
 * @date 2019/1/28 10:26
 * @description
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {
}
