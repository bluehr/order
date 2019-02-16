package cn.hr.order.enums;

/**
 * @author fys2000
 * @date 2019/1/28 11:06
 * @description
 */
public enum PayEnum {
    /**
     * 待支付
     */
    WAIT(0,"待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;
    private String msg;

    PayEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
