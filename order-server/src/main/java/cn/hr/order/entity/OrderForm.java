package cn.hr.order.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author fys2000
 * @date 2019/1/28 14:14
 * @description
 */
@Data
public class OrderForm {
    @NotNull(message = "买家姓名不能为空！")
    private String name;

    @NotNull(message = "手机不能为空！")
    private String phone;

    @NotNull(message = "买家地址不能为空！")
    private String address;

    @NotNull(message = "买家openid不能为空！")
    private String openid;

    @NotNull(message = "购物车不能为空！")
    private List<OrderDetail> items;
}
