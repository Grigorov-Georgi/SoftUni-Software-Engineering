package com.example.advquerying;

import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    @Autowired
    public Runner(ShampooRepository shampooRepository, ShampooService shampooService, IngredientService ingredientService) {
        this.shampooRepository = shampooRepository;
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) throws Exception {
//        this.shampooService.selectBySize(Size.MEDIUM).forEach(System.out::println);
//        this.shampooService.selectBySizeOrLabelId(Size.MEDIUM, 10).forEach(System.out::println);
//        this.shampooService.selectMoreExpensiveThan(BigDecimal.valueOf(5)).forEach(System.out::println);
//        this.ingredientService.selectNameStartsWith("M").forEach(System.out::println);
//        this.ingredientService.selectInNames(List.of("Lavender", "Herbs", "Apple")).forEach(System.out::println);
//        System.out.println(this.ingredientService.countPriceLowerThan(BigDecimal.valueOf(5)));
//        this.shampooService.selectByIngredientsCount(2).forEach(System.out::println);
//        this.ingredientService.deleteByName("Nettle");
        this.ingredientService.increasePriceByPercentage(0.1);
    }


}
