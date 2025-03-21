package com.codea.eccomerce.aplication.service;

import com.codea.eccomerce.aplication.repository.ProductRepository;
import com.codea.eccomerce.domain.Product;
import com.codea.eccomerce.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<Product> getProducts() {
        return productRepository.getProducts();
    }
    public Iterable<Product> getProductsByUser(User user) {
        return productRepository.getProductsByUser(user);
    }
    public Product getProductsById(Integer id) {
        return productRepository.getProductById(id);
    }
    public Product saveProduct(Product product, MultipartFile multipartFile, HttpSession httpSession) throws IOException {
        if (product.getId() == null) {
            User user = new User();
            user.setId( Integer.parseInt(httpSession.getAttribute("iduser").toString()));
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
            product.setImage(uploadFile.upload(multipartFile));
            return productRepository.saveProduct(product);
        }else{
            Product productDB = productRepository.getProductById(product.getId());
            if(multipartFile.isEmpty()){
                product.setImage(productDB.getImage());
            }else {
                if(!productDB.getImage().equals("default.jpg")){
                    uploadFile.delete( productDB.getImage());
                }
                product.setImage(uploadFile.upload(multipartFile));
            }
            product.setCode(productDB.getCode());
            product.setUser(productDB.getUser());
            product.setDateCreated(productDB.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());
            return productRepository.saveProduct(product);
        }

    }
    public void deleteProductById(Integer id) {
        productRepository.deleteProductById(id);
    }

    public Iterable<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    public Iterable<Product> searchByDescription(String description) {
        return productRepository.searchByDescription(description);
    }

    public Iterable<Product> searchByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.searchByPriceRange(minPrice, maxPrice);
    }

    public Iterable<Product> searchByCode(String code) {
        return productRepository.searchByCode(code);
    }



}
