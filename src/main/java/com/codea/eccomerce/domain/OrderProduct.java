package com.codea.eccomerce.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProduct {
    private Product product;
    private Integer quantity;
    private Order order;

    public OrderProduct(Product product, Integer quantity, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }

    public BigDecimal getTotalPrice(){
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

}
