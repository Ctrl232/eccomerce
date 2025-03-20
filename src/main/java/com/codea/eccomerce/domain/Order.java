package com.codea.eccomerce.domain;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    private Integer id;
    private LocalDate dateCreated;
    private List<OrderProduct> orderProducts;
    private User user;

    public Order() {
        this.dateCreated = LocalDate.now();
    }

    public void addOrdersProduct(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    // Sumar todos los productos que hay en la orden
    public BigDecimal getTotalOrderPrice() {
        if (orderProducts == null || orderProducts.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return orderProducts.stream()
                .map(OrderProduct::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
