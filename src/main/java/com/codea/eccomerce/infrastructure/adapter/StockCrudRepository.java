package com.codea.eccomerce.infrastructure.adapter;

import com.codea.eccomerce.domain.Stock;
import com.codea.eccomerce.infrastructure.entity.ProductEntity;
import com.codea.eccomerce.infrastructure.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {

    List<StockEntity> findByProductEntity(ProductEntity productEntity);
}
