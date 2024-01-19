package com.nhnacademy.springjpa.config;

import com.nhnacademy.springjpa.Base;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
          excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {

     @Bean
     public DataSource dataSource() {
          BasicDataSource dataSource = new BasicDataSource();
          dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

          // TODO : mysql url, 계정 설정
          dataSource.setUrl("jdbc:mysql://133.186.241.167:3306/nhn_academy_48");
          dataSource.setUsername("nhn_academy_48");
          dataSource.setPassword("/q-b(E(D7s_lI8@c");

          dataSource.setInitialSize(10);
          dataSource.setMaxTotal(10);
          dataSource.setMinIdle(10);
          dataSource.setMaxIdle(10);

          dataSource.setMaxWaitMillis(1000);

          dataSource.setTestOnBorrow(true);
          dataSource.setTestOnReturn(true);
          dataSource.setTestWhileIdle(true);

          return dataSource;
     }

}
