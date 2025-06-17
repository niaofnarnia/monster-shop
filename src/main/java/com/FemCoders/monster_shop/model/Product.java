package com.FemCoders.monster_shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 0, message = "Price must be positive")
    private double price;

    @NotBlank(message = "Image URL is required")
    private String imageUrl;

    @Min(0)
    @Max(5)
    private double rating;

    @Min(0)
    private int reviewCount;

    private boolean featured;

}
