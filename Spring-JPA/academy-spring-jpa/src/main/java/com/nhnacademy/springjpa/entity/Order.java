package com.nhnacademy.springjpa.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders")
public class Order {

     @Id
     @Column(name = "order_id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long orderId;

     @JoinColumn(name = "cus_id")
     @ManyToOne
     private Customer customerId;

     @Column(name = "order_date")
     @Temporal(value = TemporalType.TIMESTAMP)
     private Date orderDate;

     @Column(name = "ship_date")
     @Temporal(value = TemporalType.TIMESTAMP)
     private Date shipDate;
}
