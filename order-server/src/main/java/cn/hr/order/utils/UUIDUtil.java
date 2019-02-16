package cn.hr.order.utils;

import java.util.UUID;

/**
 * @author fys2000
 * @date 2019/2/15 09:15
 * @description
 */
public class UUIDUtil {
    public static String getKey(){
         return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
