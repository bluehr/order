package cn.hr.order.controller;

import cn.hr.order.VO.ResultVO;
import cn.hr.order.entity.OrderForm;
import cn.hr.order.entity.dto.OrderDTO;
import cn.hr.order.service.OrderService;
import cn.hr.order.utils.OrderConvert;
import cn.hr.order.utils.ParamCheckUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fys2000
 * @date 2019/1/28 13:56
 * @description
 */
@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping("/create")
    @ApiOperation(value = "创建订单")
    @ResponseBody
    public ResultVO createOrder(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult) {
        //查询商品信息
        ParamCheckUtil.checkParam(bindingResult, log);
        OrderDTO orderDTO = OrderConvert.convert2OrderDTO(orderForm);
        orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>(1);
        map.put("orderId", orderDTO.getOrderId());
        return ResultVO.SUCCESS(map);
    }

}
