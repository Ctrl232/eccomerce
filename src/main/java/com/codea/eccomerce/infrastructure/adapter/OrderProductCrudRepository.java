package com.codea.eccomerce.infrastructure.adapter;

import com.codea.eccomerce.infrastructure.entity.OderProductEntity;
import org.springframework.data.repository.CrudRepository;
import com.codea.eccomerce.infrastructure.entity.OrderEntity;

import java.util.List;

public interface OrderProductCrudRepository extends CrudRepository<OderProductEntity, Integer> {
    List<OderProductEntity> findByPkOrderEntity(OrderEntity oderEntity);
}
