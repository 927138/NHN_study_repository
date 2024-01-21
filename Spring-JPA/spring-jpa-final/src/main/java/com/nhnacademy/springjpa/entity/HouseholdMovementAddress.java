package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {

     @EmbeddedId
     private MovementAddressPk movementAddressPk;

     @MapsId("householdSerialNumber")
     @ManyToOne
     @JoinColumn(name = "household_serial_number")
     private HouseHold householdSerialNumber;

     @Column(name = "house_movement_address")
     private String houseMovementAddress;

     @Column(name = "last_address_yn")
     private String lastAddressVn;

     @NoArgsConstructor
     @AllArgsConstructor
     @EqualsAndHashCode
     @Setter @Getter
     @Embeddable
     public static class MovementAddressPk implements Serializable {
          @Column(name = "household_serial_number")
          private Integer householdSerialNumber;

          @Temporal(TemporalType.TIMESTAMP)
          @Column(name = "house_movement_report_date")
          private Date houseMovementReportDate;

     }
}
