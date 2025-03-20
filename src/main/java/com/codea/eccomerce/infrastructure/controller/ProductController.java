package com.codea.eccomerce.infrastructure.controller;

import com.codea.eccomerce.aplication.service.ProductService;
import com.codea.eccomerce.domain.Product;
import com.codea.eccomerce.domain.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

@Controller
@RequestMapping("/admin/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String create() {
        return "admin/products/create";
    }

    @PostMapping("/save-product")
    public String saveProduct(Product product, @RequestParam("img") MultipartFile multipartFile, HttpSession httpSession ) throws IOException {
        log.info("Nombre del producto {}", product);
        productService.saveProduct(product, multipartFile, httpSession );
        //return "admin/products/create";
        return "redirect:/admin";
        }
    @GetMapping("/show")
    public String showProducts(Model model, HttpSession httpSession) {
        User user = new User();
        user.setId(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        Iterable <Product> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/products/show";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        Product product = productService.getProductsById(id);
        log.info("Producto obtenido {}", product);
        model.addAttribute("product", product);
        return "admin/products/edit";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
        return "redirect:/admin/products/show";
    }




}
