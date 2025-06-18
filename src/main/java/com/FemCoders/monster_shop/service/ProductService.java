package com.FemCoders.monster_shop.service;

import com.FemCoders.monster_shop.dto.product.ProductMapper;
import com.FemCoders.monster_shop.dto.product.ProductRequest;
import com.FemCoders.monster_shop.dto.product.ProductResponse;
import com.FemCoders.monster_shop.model.Product;
import com.FemCoders.monster_shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toResponse(product);
    }

    public ProductResponse saveProduct(ProductRequest productRequest) {
        Product product = ProductMapper.toEntity(productRequest);
        Product saved = productRepository.save(product);
        return ProductMapper.toResponse(saved);
    }

    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(productRequest.getName());
        existing.setPrice(productRequest.getPrice());
        existing.setImageUrl(productRequest.getImageUrl());
        existing.setFeatured(productRequest.isFeatured());

        Product updated = productRepository.save(existing);
        return ProductMapper.toResponse(updated);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}