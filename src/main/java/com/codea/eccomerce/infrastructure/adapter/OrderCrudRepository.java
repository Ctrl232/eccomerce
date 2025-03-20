package com.codea.eccomerce.infrastructure.adapter;

import com.codea.eccomerce.domain.User;
import com.codea.eccomerce.infrastructure.entity.OrderEntity;
import com.codea.eccomerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
    public Iterable<OrderEntity> findByUser(UserEntity userEntity);
}
