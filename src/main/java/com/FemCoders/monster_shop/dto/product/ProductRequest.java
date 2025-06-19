package com.FemCoders.monster_shop.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductRequest {

    @NotBlank(message = "Name is required")
    private String name;

    public String getName() {
        return name;
    }

    @Min(value = 0, message = "Price must be positive")
    private double price;

    public double getPrice() {
        return price;
    }

    @NotBlank(message = "Image URL is required")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    private boolean featured;

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    @NotBlank(message = "Description is required")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

