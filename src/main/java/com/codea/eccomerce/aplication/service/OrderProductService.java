package com.codea.eccomerce.aplication.service;

import com.codea.eccomerce.aplication.repository.OrderProductRepository;
import com.codea.eccomerce.domain.Order;
import com.codea.eccomerce.domain.OrderProduct;

import java.util.List;

public class OrderProductService {
    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductRepository.create(orderProduct);
    }

    public Iterable<OrderProduct> getOrderProducts() {
        return orderProductRepository.getOrderProducts();
    }
    public List<OrderProduct> getOrderProductsByOrderId(Order order) {
        return orderProductRepository.getOrdersProductsByOrder(order);
    }
}

