package com.example.demo.entities.games;

import java.math.BigDecimal;

public class GameEditDto {
    private float size;
    private BigDecimal price;

    public GameEditDto(String[] commandParts) {
        this.size = Float.parseFloat(commandParts[3]);
        this.price = BigDecimal.valueOf(Double.parseDouble(commandParts[2]));
    }

    public float getSize() {
        return size;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
