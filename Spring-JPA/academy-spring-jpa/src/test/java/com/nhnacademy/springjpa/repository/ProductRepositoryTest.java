package com.nhnacademy.springjpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.domain.ProductViewDTO;
import com.nhnacademy.springjpa.entity.Product;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})

class ProductRepositoryTest {

     @Autowired
     private ProductRepository productRepository;

     @Test
     void existsId(){

          assertThat(productRepository.existsByProductId(2L)).isTrue();

          int cnt = productRepository.findAll().size();
          assertEquals(2, cnt);

          productRepository.flush();

     }

     @Test
     void projectionTest(){


     }
}