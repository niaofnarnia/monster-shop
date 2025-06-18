package com.FemCoders.monster_shop.dto.product;

public class ProductResponse {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    private double price;

    public void setPrice(double price) {
        this.price = price;
    }

    private String imageUrl;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private double rating;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private int reviewCount;

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    private boolean featured;

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

}

