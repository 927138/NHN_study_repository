package com.nhnacademy.springjpa.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Products")
public class Product {

     @Id
     @Column(name = "prod_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long productId;

     @ManyToOne
     @JoinColumn(name = "category_id")
     private Category categoryId;

     @Column(name = "model_number")
     private String modelNumber;

     @Column(name = "model_name")
     private String modelName;

     @Column(name = "prod_image")
     private String productImage;

     @Column(name = "unit_cost")
     private BigDecimal unitCost;

     private String description;
}
