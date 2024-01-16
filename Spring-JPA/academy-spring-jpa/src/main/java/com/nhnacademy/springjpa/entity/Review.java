package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reviews")
public class Review {

     @Id
     @Column(name = "review_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long reviewId;

     @Column(name = "prod_id")
     private Long productId;

     @Column(name = "cus_id")
     private Long customerId;

     private int rating;
     private String comments;


}
