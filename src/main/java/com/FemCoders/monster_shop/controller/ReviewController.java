package com.FemCoders.monster_shop.controller;

import com.FemCoders.monster_shop.dto.review.ReviewRequest;
import com.FemCoders.monster_shop.dto.review.ReviewResponse;
import com.FemCoders.monster_shop.service.ReviewService;
import jakarta.validation.Valid;
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
    public List<ReviewResponse> getByProductId(@PathVariable Long productId) {
        return reviewService.getReviewsByProductId(productId);
    }

    @PostMapping("/{productId}")
    public ReviewResponse create(
            @PathVariable Long productId,
            @RequestBody @Valid ReviewRequest reviewRequest
    ) {
        return reviewService.saveReview(reviewRequest, productId);
    }
}
