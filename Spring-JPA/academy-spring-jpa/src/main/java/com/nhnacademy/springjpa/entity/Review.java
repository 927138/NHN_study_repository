package com.nhnacademy.springjpa.entity;

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

@Entity
@Table(name = "Reviews")
public class Review {

     @Id
     @Column(name = "review_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long reviewId;

     @JoinColumn(name = "cus_id")
     @ManyToOne
     private Customer customerId;

     @JoinColumn(name = "prod_id")
     @OneToMany
     private List<Product> productId;

     private int rating;
     private String comments;


}
