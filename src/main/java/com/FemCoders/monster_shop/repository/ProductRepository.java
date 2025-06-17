package com.FemCoders.monster_shop.repository;

import com.FemCoders.monster_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}