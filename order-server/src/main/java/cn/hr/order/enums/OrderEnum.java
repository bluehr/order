package cn.hr.order.enums;

import lombok.Getter;

/**
 * @author fys2000
 * @date 2019/1/28 11:00
 * @description
 */
@Getter
public enum OrderEnum {
    /**
     * 新订单
     */
    NEW(0,"新订单"),
    FINISH(1,"已完成"),
    CANCEL(2,"已取消"),
    ;

    OrderEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

}
