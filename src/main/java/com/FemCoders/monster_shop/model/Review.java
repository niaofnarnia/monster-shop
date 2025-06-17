package com.FemCoders.monster_shop.model;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private double rating;
    private String body;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}