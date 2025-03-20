package com.codea.eccomerce.aplication.service;

import com.codea.eccomerce.aplication.repository.OrderRepository;
import com.codea.eccomerce.domain.Order;
import com.codea.eccomerce.domain.User;

public class OrderService {
    private final OrderRepository orderRepository;
     public OrderService(OrderRepository orderRepository) {
         this.orderRepository = orderRepository;
     }
     public Order createOrder(Order order) {
        return orderRepository.createOrder(order);
     }
     public Iterable<Order> getOrders() {
         return orderRepository.getOrders();
     }

     public Iterable<Order> getOrdersByUser(User user) {
         return orderRepository.getOrdersByUsers(user);
     }
}
