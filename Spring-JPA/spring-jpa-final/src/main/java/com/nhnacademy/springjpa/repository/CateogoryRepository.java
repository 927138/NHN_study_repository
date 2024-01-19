package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateogoryRepository extends JpaRepository<Category, Integer> {
     List<Category> findAllBy();
}
