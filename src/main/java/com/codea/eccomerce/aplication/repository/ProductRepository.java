package com.codea.eccomerce.aplication.repository;

import com.codea.eccomerce.domain.Product;
import com.codea.eccomerce.domain.User;


public interface ProductRepository {
    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(User user);
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProductById(Integer id);


}

