package com.FemCoders.monster_shop.service;

import com.FemCoders.monster_shop.dto.review.ReviewRequest;
import com.FemCoders.monster_shop.dto.review.ReviewResponse;
import com.FemCoders.monster_shop.dto.review.ReviewMapper;
import com.FemCoders.monster_shop.model.Product;
import com.FemCoders.monster_shop.model.Review;
import com.FemCoders.monster_shop.repository.ProductRepository;
import com.FemCoders.monster_shop.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<ReviewResponse> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream()
                .map(ReviewMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ReviewResponse saveReview(ReviewRequest reviewRequest, Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product with ID " + productId + " not found"));

        Review review = ReviewMapper.toEntity(reviewRequest);
        review.setProduct(product);
        reviewRepository.save(review);

        List<Review> reviews = reviewRepository.findByProductId(productId);
        double average = reviews.stream().mapToDouble(Review::getRating).average().orElse(0);
        int count = reviews.size();

        product.setRating(average);
        product.setReviewCount(count);
        productRepository.save(product);

        return ReviewMapper.toResponse(review);

    }
}