package cn.hr.order.controller;

import cn.hr.product.client.ProductClient;
import cn.hr.product.common.DecreaseStockInput;
import cn.hr.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author fys2000
 * @date 2019/1/28 19:51
 * @description
 */
@RestController
@Slf4j
public class ClientController {
    @Autowired
    ProductClient productClient;

    @GetMapping("/listProduct")
    public String listProduct() {
        List<ProductInfoOutput> productInfos = productClient.listProductByIds(Arrays.asList("157875227953464068"));
        log.info(productInfos.toString());
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("157875227953464068",2)));
        return "ok";
    }
}
