package com.codea.eccomerce.infrastructure.adapter;

import com.codea.eccomerce.domain.Product;
import com.codea.eccomerce.infrastructure.entity.ProductEntity;
import com.codea.eccomerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);

}

