package com.codea.eccomerce.infrastructure.adapter;

import com.codea.eccomerce.aplication.repository.ProductRepository;
import com.codea.eccomerce.domain.Product;
import com.codea.eccomerce.domain.User;
import com.codea.eccomerce.infrastructure.entity.ProductEntity;
import com.codea.eccomerce.infrastructure.mapper.ProductMapper;
import com.codea.eccomerce.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductCrudRepository productCrudRepository;
    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository, ProductMapper productMapper, UserMapper userMapper) {
        this.productCrudRepository = productCrudRepository;
        this.productMapper = productMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Iterable<Product> getProducts() {
        return productMapper.toProducts(productCrudRepository.findAll());
    }

    @Override
    public Iterable<Product> getProductsByUser(User user) {
        return productMapper.toProducts(productCrudRepository.findByUserEntity(userMapper.toUserEntity(user)));
    }

    @Override
    public Product getProductById(Integer id) {
        return productMapper.toProduct(productCrudRepository.findById(id).get());
    }

    @Override
    public Product saveProduct(Product product) {
        return productMapper.toProduct(productCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public void deleteProductById(Integer id) {
        productCrudRepository.deleteById(id);
    }

    // Implementación de métodos de búsqueda
    @Override
    public Iterable<Product> searchByName(String name) {
        return productMapper.toProducts(productCrudRepository.findByNameContainingIgnoreCase(name));
    }


    @Override
    public Iterable<Product> searchByDescription(String description) {
        return productMapper.toProducts(productCrudRepository.findByDescriptionContainingIgnoreCase(description));
    }


    @Override
    public Iterable<Product> searchByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productMapper.toProducts(productCrudRepository.findByPriceBetween(minPrice, maxPrice));
    }


    @Override
    public Iterable<Product> searchByCode(String code) {
        ProductEntity productEntity = productCrudRepository.findByCode(code);
        return productEntity != null ? List.of(productMapper.toProduct(productEntity)) : List.of();
    }



}
