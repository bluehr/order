package cn.hr.order.utils;

import cn.hr.order.exception.OrderException;
import org.slf4j.Logger;
import org.springframework.validation.BindingResult;

/**
 * @author fys2000
 * @date 2019/1/28 14:20
 * @description
 */
public class ParamCheckUtil {
    public static void checkParam(BindingResult bindingResult, Logger logger) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> {
                logger.error("订单参数异常："+error.getDefaultMessage());
                throw new OrderException(error.getDefaultMessage(), 500);
            });
        }
    }
}
