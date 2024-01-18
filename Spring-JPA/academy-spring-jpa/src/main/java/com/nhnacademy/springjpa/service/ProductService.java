package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.ProductViewDTO;
import com.nhnacademy.springjpa.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

     Page<ProductViewDTO> pageSlice(Pageable pageable);
     int startRange(Page<ProductViewDTO> products);

     int finishRange(Page<ProductViewDTO> products, int start);

}
