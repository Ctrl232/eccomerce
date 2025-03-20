package com.codea.eccomerce.infrastructure.controller;

import com.codea.eccomerce.aplication.service.ProductService;
import com.codea.eccomerce.aplication.service.StockService;
import com.codea.eccomerce.domain.Stock;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final ProductService productService;
    private final StockService stockService;

    public HomeController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }


    @GetMapping
    public String home(Model model, HttpSession httpsession) {
        model.addAttribute("products", productService.getProducts());
        try {
            model.addAttribute("id", httpsession.getAttribute("iduser").toString());
        }catch (Exception e) {

        }
        return "home";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Integer id, Model model, HttpSession httpsession) {
        List<Stock> stocks = stockService.getStockByProduct(productService.getProductsById(id));
        Integer lastBalance = stocks.get(stocks.size()-1).getBalance();
        model.addAttribute("product", productService.getProductsById(id));
        model.addAttribute("stock", lastBalance);
        try {
            model.addAttribute("id", httpsession.getAttribute("iduser").toString());
        }catch (Exception e) {

        }
        return "user/productDetail";
    }
}
