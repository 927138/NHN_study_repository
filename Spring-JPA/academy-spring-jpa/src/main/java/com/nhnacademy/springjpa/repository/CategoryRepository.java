package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.Pick;
import com.nhnacademy.springjpa.entity.Category;
import com.nhnacademy.springjpa.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, OrderDetail.Pk> {

     Category findByCategoryId(Long categoryId);

     @Pick
     boolean existsByCategoryName(String categoryName);
}
