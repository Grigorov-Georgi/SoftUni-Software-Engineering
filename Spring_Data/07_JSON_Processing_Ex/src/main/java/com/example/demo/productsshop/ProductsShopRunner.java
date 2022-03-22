package com.example.demo.productsshop;

import com.example.demo.productsshop.entities.categories.CategoryStats;
import com.example.demo.productsshop.entities.products.ProductWithoutBuyerDTO;
import com.example.demo.productsshop.entities.users.UserWithSoldProductsDTO;
import com.example.demo.productsshop.services.ProductsService;
import com.example.demo.productsshop.services.SeedService;
import com.example.demo.productsshop.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;

@Component
public class ProductsShopRunner implements CommandLineRunner {

    private final SeedService seedService;
    private final ProductsService productsService;
    private final UserService userService;

    private final Gson gson;

    @Autowired
    public ProductsShopRunner(SeedService seedService, ProductsService productsService, UserService userService) {
        this.seedService = seedService;
        this.productsService = productsService;
        this.userService = userService;

        this.gson = new GsonBuilder()
        .setPrettyPrinting()
        .create();
    }

    @Override
    public void run(String... args) throws Exception {
//        this.seedService.seedUsers();
//        this.seedService.seedCategories();
//        this.seedService.seedProducts();
//        this.seedService.seedAll();

//        getAllWithSoldProducts();
//        getUsersWithSoldProducts();
//        getCategoryStats();

    }

    private void getCategoryStats() {
        List<CategoryStats> categoryStatistics = this.productsService.getCategoryStatistics();
        String json = this.gson.toJson(categoryStatistics);
        System.out.println(json);
    }

    private void getUsersWithSoldProducts() {
        List<UserWithSoldProductsDTO> userWithSoldProducts = this.userService.getUsersWithSoldProducts();

        String json = this.gson.toJson(userWithSoldProducts);

        System.out.println(json);
    }

    private void getAllWithSoldProducts() throws FileNotFoundException {
        List<ProductWithoutBuyerDTO> productsForSell = this.productsService.getProductsInPriceRangeForSell(500, 1000);
        String result = this.gson.toJson(productsForSell);
        System.out.println(result);
    }
}
