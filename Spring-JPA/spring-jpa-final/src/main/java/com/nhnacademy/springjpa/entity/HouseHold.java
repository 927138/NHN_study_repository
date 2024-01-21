package com.nhnacademy.springjpa.entity;


import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "household")
public class HouseHold {

     @Id
     @Column(name = "household_serial_number")
     private Integer householdSerialNumber;

     @ManyToOne
     @JoinColumn(name = "household_resident_serial_number", referencedColumnName = "resident_serial_number")
     private Resident householdResidentSerialNumber;

     @Temporal(value = TemporalType.TIMESTAMP)
     @Column(name = "household_composition_date")
     private Date householdCompositionDate;

     @Column(name = "household_composition_reason_code")
     private String householdCompositionReasonCode;

     @Column(name = "current_house_movement_address")
     private String currentHouseMovementAddress;
}
