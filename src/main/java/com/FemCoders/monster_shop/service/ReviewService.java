package com.FemCoders.monster_shop.service;

import com.FemCoders.monster_shop.model.Review;
import com.FemCoders.monster_shop.repository.ReviewRepository;
import com.FemCoders.monster_shop.repository.ProductRepository;
import com.FemCoders.monster_shop.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }

    public Review saveReview(Review review, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        review.setProduct(product);
        return reviewRepository.save(review);
    }
}