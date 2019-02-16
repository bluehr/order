package cn.hr.order.dao;

import cn.hr.order.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fys2000
 * @date 2019/1/28 10:35
 * @description
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {

}
