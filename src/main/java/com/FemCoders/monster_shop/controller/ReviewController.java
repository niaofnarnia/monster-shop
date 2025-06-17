package com.FemCoders.monster_shop.controller;

import com.FemCoders.monster_shop.model.Review;
import com.FemCoders.monster_shop.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{productId}")
    public List<Review> getByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }

    @PostMapping("/{productId}")
    public Review create(@PathVariable Long productId, @RequestBody Review review) {
        return reviewService.saveReview(review, productId);
    }
}