package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OrderDetails")
@IdClass(OrderDetail.Pk.class)
public class OrderDetail {

     @Id
     @Column(name = "order_id")
     private Long orderId;

     @Id
     @Column(name = "prod_id")
     private Long productId;

     private int quantity;

     @Column(name = "unit_cost")
     private BigDecimal unitCost;


     @NoArgsConstructor
     @AllArgsConstructor
     @EqualsAndHashCode
     public static class Pk implements Serializable {
          private Long orderId;
          private Long productId;
     }

}
