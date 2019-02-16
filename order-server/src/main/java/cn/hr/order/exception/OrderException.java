package cn.hr.order.exception;

/**
 * @author fys2000
 * @date 2019/1/28 14:21
 * @description
 */
public class OrderException extends RuntimeException {
    private Integer code;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public OrderException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
