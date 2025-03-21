package com.codea.eccomerce.infrastructure.adapter;

import com.codea.eccomerce.domain.Product;
import com.codea.eccomerce.infrastructure.entity.ProductEntity;
import com.codea.eccomerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;


public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {

    List<ProductEntity> findByNameContainingIgnoreCase(String name);

    List<ProductEntity> findByDescriptionContainingIgnoreCase(String description);

    List<ProductEntity> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<ProductEntity> findByUserEntity(UserEntity userEntity);

    ProductEntity findByCode(String code);

}

