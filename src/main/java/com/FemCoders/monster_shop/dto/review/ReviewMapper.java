package com.FemCoders.monster_shop.dto.review;

import com.FemCoders.monster_shop.model.Review;

public class ReviewMapper {

    public static ReviewResponse toResponse(Review review) {
        ReviewResponse dto = new ReviewResponse();
        dto.setId(review.getId());
        dto.setUsername(review.getUsername());
        dto.setRating(review.getRating());
        dto.setBody(review.getBody());
        return dto;
    }

    public static Review toEntity(ReviewRequest request) {
        Review review = new Review();
        review.setUsername(request.getUsername());
        review.setRating(request.getRating());
        review.setBody(request.getBody());
        return review;
    }
}
