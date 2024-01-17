package com.nhnacademy.springjpa.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Categories")
public class Category {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "category_id")
     private Long categoryId;

     @Column(name = "category_name")
     private String categoryName;

     @OneToMany(mappedBy = "categoryId")
     private List<Product> products;
}
