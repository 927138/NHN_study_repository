package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.Pick;
import com.nhnacademy.springjpa.entity.Category;
import com.nhnacademy.springjpa.entity.Customer;
import com.nhnacademy.springjpa.entity.OrderDetail;
import com.nhnacademy.springjpa.entity.Product;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

     @Query("select c from Category c")
     List<Category> findAllBy();
     @Query("select c from Category c where c.categoryId = ?1")
     Category findByCategoryId(Long categoryId);
     boolean existsByCategoryName(String categoryName);
}
