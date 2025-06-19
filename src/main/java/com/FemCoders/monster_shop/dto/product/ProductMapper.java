package com.FemCoders.monster_shop.dto.product;

import com.FemCoders.monster_shop.model.Product;

public class ProductMapper {

    public static ProductResponse toResponse(Product product) {
        ProductResponse dto = new ProductResponse();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setImageUrl(product.getImageUrl());
        dto.setRating(product.getRating());
        dto.setReviewCount(product.getReviewCount());
        dto.setFeatured(product.isFeatured());
        return dto;
    }

    public static Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setImageUrl(request.getImageUrl());
        product.setFeatured(request.isFeatured());
        return product;
    }


}

