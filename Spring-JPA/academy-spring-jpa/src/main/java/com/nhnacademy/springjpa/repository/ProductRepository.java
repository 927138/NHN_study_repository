package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.ProductViewDTO;
import com.nhnacademy.springjpa.entity.Product;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
     List<Product> findByCategoryId_CategoryId(Long id);
     List<Product> findByUnitCostGreaterThan(BigDecimal unitCost);
     List<Product> findByUnitCostLessThan(BigDecimal unitCost);
     Product findByModelName(String modelName);
     boolean existsByProductId(Long productId);

     Page<ProductViewDTO> getAllBy(Pageable pageable);

}
