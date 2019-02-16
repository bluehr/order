package cn.hr.order.entity.dto;

import lombok.Data;

/**
 * @author fys2000
 * @date 2019/1/29 10:44
 * @description
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "productId='" + productId + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                '}';
    }
}
