package com.codea.eccomerce.infrastructure.adapter;

import com.codea.eccomerce.aplication.repository.OrderRepository;
import com.codea.eccomerce.domain.Order;
import com.codea.eccomerce.domain.User;
import com.codea.eccomerce.infrastructure.mapper.OrderMapper;
import com.codea.eccomerce.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderCrudRepository orderCrudRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository, OrderMapper orderMapper, UserMapper userMapper) {
        this.orderCrudRepository = orderCrudRepository;
        this.orderMapper = orderMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Order createOrder(Order order) {
        return orderMapper.toOrder(orderCrudRepository.save(orderMapper.toOrderEntity(order)));
    }

    @Override
    public Iterable<Order> getOrders() {
        return orderMapper.toOrders(orderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> getOrdersByUsers(User user) {
        return orderMapper.toOrders(orderCrudRepository.findByUser(userMapper.toUserEntity(user))) ;
    }
}
