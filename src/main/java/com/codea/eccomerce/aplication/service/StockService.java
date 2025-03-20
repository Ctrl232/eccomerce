package com.codea.eccomerce.aplication.service;

import com.codea.eccomerce.aplication.repository.StockRepository;
import com.codea.eccomerce.domain.Product;
import com.codea.eccomerce.domain.Stock;

import java.util.List;

public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public Stock saveStock(Stock stock) {
        return stockRepository.saveStock(stock);
    }
    public List<Stock> getStockByProduct(Product product) {
        return stockRepository.getStockByProduct(product);
    }
}
