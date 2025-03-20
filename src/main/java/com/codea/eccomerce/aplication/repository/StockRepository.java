package com.codea.eccomerce.aplication.repository;

import com.codea.eccomerce.domain.Product;
import com.codea.eccomerce.domain.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StockRepository {
    Stock saveStock(Stock stock);
    List<Stock> getStockByProduct(Product product);

}
