package com.example.demo.productsshop.services;

import com.example.demo.productsshop.entities.categories.CategoryStats;
import com.example.demo.productsshop.entities.products.Product;
import com.example.demo.productsshop.entities.products.ProductWithoutBuyerDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductsService {
    List<ProductWithoutBuyerDTO> getProductsInPriceRangeForSell(float from, float to);

    List<CategoryStats> getCategoryStatistics();
}
