package com.codea.eccomerce.aplication.repository;

import com.codea.eccomerce.domain.Order;
import com.codea.eccomerce.domain.User;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
    public Iterable <Order> getOrdersByUsers(User user);
}
