package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "OrderDetails")
public class OrderDetail {

     @EmbeddedId
     private Pk pk;

     @MapsId("orderId")
     @JoinColumn(name = "order_id")
     @OneToOne
     private Order orderId;

     @MapsId("productId")
     @JoinColumn(name = "prod_id")
     @OneToOne
     private Product productId;

     private int quantity;

     @Column(name = "unit_cost")
     private BigDecimal unitCost;


     @NoArgsConstructor
     @AllArgsConstructor
     @EqualsAndHashCode
     @Embeddable
     public static class Pk implements Serializable {
          private Long orderId;
          private Long productId;
     }

}
