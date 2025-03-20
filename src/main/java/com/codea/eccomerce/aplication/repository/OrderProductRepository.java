package com.codea.eccomerce.aplication.repository;

import com.codea.eccomerce.domain.Order;
import com.codea.eccomerce.domain.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    public OrderProduct create(OrderProduct orderProduct);
    public Iterable<OrderProduct> getOrderProducts();
    List<OrderProduct> getOrdersProductsByOrder(Order order);
}
