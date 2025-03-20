package com.codea.eccomerce.infrastructure.adapter;

import com.codea.eccomerce.aplication.repository.OrderProductRepository;
import com.codea.eccomerce.domain.Order;
import com.codea.eccomerce.domain.OrderProduct;
import com.codea.eccomerce.infrastructure.mapper.OrderMapper;
import com.codea.eccomerce.infrastructure.mapper.OrderProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository {
    private final OrderProductCrudRepository productCrudRepository;
    private final OrderMapper orderMapper;
    private final OrderProductMapper orderProductMapper;

    public OrderProductRepositoryImpl(OrderProductCrudRepository productCrudRepository,OrderMapper orderMapper,OrderProductMapper orderProductMapper) {
        this.productCrudRepository = productCrudRepository;
        this.orderMapper = orderMapper;
        this.orderProductMapper = orderProductMapper;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return orderProductMapper.toOrderProduct(productCrudRepository.save(orderProductMapper.toOderProductEntity(orderProduct)));
    }

    @Override
    public Iterable<OrderProduct> getOrderProducts() {
        return orderProductMapper.toOrderProducts(productCrudRepository.findAll());
    }

    @Override
    public List<OrderProduct> getOrdersProductsByOrder(Order order) {
        return orderProductMapper.toOrderProductList(productCrudRepository.findByPkOrderEntity(orderMapper.toOrderEntity(order)));
    }
}
