package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Product;
import com.nhnacademy.springjpa.entity.Review;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
     List<Review> findByProductId_ProductId(Long productId);
     List<Review> findByCommentsContaining(String curse);
     Long countByProductId_ProductId(Long productId);
}
