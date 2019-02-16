package cn.hr.order.VO;

import lombok.Data;

/**
 * @author fys2000
 * @date 2019/1/24 16:48
 * @description
 */
@Data
public class ResultVO<T> {
    /**
     * 数据对象
     */
    private T data;
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误提示信息
     */
    private String msg;

    public static ResultVO SUCCESS(Object obj) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(obj);
        return resultVO;
    }
}
