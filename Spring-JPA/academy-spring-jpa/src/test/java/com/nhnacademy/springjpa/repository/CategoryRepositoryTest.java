package com.nhnacademy.springjpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.nhnacademy.springjpa.Pick;
import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import java.lang.reflect.Method;
import java.util.Arrays;
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
class CategoryRepositoryTest {

     @Autowired
     private CategoryRepository categoryRepository;


     @Test
     void test(){

          Class<?> clazz = Arrays.stream(categoryRepository.getClass().getInterfaces())
                  .filter(InterFace -> InterFace.isAssignableFrom(CategoryRepository.class))
                  .findFirst()
                  .orElse(null);

          assertThat(clazz).isNotNull();

          Method pickMethod =
                  Arrays.stream(clazz.getDeclaredMethods())
                          .filter(method -> method.isAnnotationPresent(Pick.class))
                          .findFirst()
                          .orElse(null);

          assertThat(pickMethod).isNotNull();
     }
}