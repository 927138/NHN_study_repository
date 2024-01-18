package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ProductViewDTO;
import com.nhnacademy.springjpa.entity.Product;
import com.nhnacademy.springjpa.exception.PageNullPointerException;
import com.nhnacademy.springjpa.repository.ProductRepository;
import java.util.Objects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

     private final ProductRepository productRepository;
     private final int PAGE_RANGE = 3;

     public ProductServiceImpl(ProductRepository productRepository) {
          this.productRepository = productRepository;
     }

     @Override
     public Page<ProductViewDTO> pageSlice(Pageable pageable){
          return productRepository.getAllBy(pageable);
     }

     @Override
     public int startRange(Page<ProductViewDTO> products) {
          if(Objects.isNull(products))
               throw new PageNullPointerException();

          int pageNumber = products.getNumber();
          return ((pageNumber / PAGE_RANGE) * PAGE_RANGE) + 1;
     }

     @Override
     public int finishRange(Page<ProductViewDTO> products, int start) {
          if(Objects.isNull(products))
               throw new PageNullPointerException();

          return Math.min(start + PAGE_RANGE - 1, products.getTotalPages());
     }
}
