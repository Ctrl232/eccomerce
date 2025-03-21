package com.codea.eccomerce.aplication.repository;

import com.codea.eccomerce.domain.Product;
import com.codea.eccomerce.domain.User;

import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository {
    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(User user);
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);

    // Métodos de búsqueda
    Iterable<Product> searchByName(String name);
    Iterable<Product> searchByDescription(String description);
    Iterable<Product> searchByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    Iterable<Product> searchByCode(String code);
}

