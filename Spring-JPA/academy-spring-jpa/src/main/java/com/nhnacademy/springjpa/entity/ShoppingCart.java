package com.nhnacademy.springjpa.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class ShoppingCart {

     @Id
     @Column(name = "record_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long recordId;

     @Column(name = "cart_id")
     private String cartId;

     private int quantity;

     @Column(name = "prod_id")
     private Long productId;

     @Column(name = "date_created")
     private Date dateCreated;

}
