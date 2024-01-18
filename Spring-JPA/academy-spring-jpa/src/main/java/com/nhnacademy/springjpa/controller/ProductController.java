package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.ProductViewDTO;
import com.nhnacademy.springjpa.entity.Product;
import com.nhnacademy.springjpa.service.ProductService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

     private final ProductService productService;

     public ProductController(ProductService productService) {
          this.productService = productService;
     }

     private final int PAGE_RANGE = 3;

     @GetMapping("/test")
     public String test1() {
          return "productView";
     }

     @GetMapping("/productPaging")
     public String test(Model model,
                        @PageableDefault(size = 6, page = 0, direction = Sort.Direction.DESC) Pageable pageable) {

          Page<ProductViewDTO> products = productService.pageSlice(pageable);

          int start = productService.startRange(products);
          int finish = productService.finishRange(products, start);

          model.addAttribute("start", start);
          model.addAttribute("finish", finish);
          model.addAttribute("page", products);

          return "productView";
     }
}
