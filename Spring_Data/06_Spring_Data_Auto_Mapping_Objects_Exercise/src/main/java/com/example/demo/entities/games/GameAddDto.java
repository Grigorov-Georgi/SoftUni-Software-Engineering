package com.example.demo.entities.games;

import com.example.demo.exceptions.ValidationException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GameAddDto {
    private String title;

    private String trailerId;

    private String thumbnailUrl;

    private float size;

    private BigDecimal price;

    private String description;

    private LocalDate releaseDate;

    public GameAddDto(String[] commandParts) {
        this.setTitle(commandParts[1]);
        this.setPrice(BigDecimal.valueOf(Double.parseDouble(commandParts[2])));
        this.setSize(Float.parseFloat(commandParts[3]));
        this.setTrailerId(commandParts[4]);
        this.setThumbnailUrl(commandParts[5]);
        this.setDescription(commandParts[6]);
        this.setReleaseDate(parseStringToLocalDate(commandParts[7]));
    }

    private LocalDate parseStringToLocalDate(String text) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate localDate = LocalDate.parse(text, formatter);
        return localDate;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public float getSize() {
        return size;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setTitle(String title) {
        if (!Character.isUpperCase(title.charAt(0)) || title.length() < 3 || title.length() > 100) {
            throw new ValidationException("Incorrect format for title");
        } else {
            this.title = title;
        }
    }

    public void setTrailerId(String trailerId) {
        if (trailerId.length() != 11) {
            throw new ValidationException("Trailer ID must be exactly 11 characters long");
        } else {
            this.trailerId = trailerId;
        }
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        if (!thumbnailUrl.split("//")[0].equals("http:") && !thumbnailUrl.split("//")[0].equals("https:")) {
            throw new ValidationException("Wrong thumbnail URL");
        } else {
            this.thumbnailUrl = thumbnailUrl;
        }
    }

    public void setSize(float size) {
        if (size < 0) {
            throw new ValidationException("Size must be positive number");
        } else {
            this.size = size;
        }
    }

    public void setPrice(BigDecimal price) {
        if (price.floatValue() < 0) {
            throw new ValidationException("Price must be positive number");
        } else {
            this.price = price;
        }
    }

    public void setDescription(String description) {
        if (description.length() <= 20) {
            throw new ValidationException("Description must be at least 20 symbols");
        } else {
            this.description = description;
        }
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
