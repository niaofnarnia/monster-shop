package com.FemCoders.monster_shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @Min(0)
    @Max(5)
    private double rating;

    @NotBlank(message = "Review body cannot be empty")
    private String body;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}