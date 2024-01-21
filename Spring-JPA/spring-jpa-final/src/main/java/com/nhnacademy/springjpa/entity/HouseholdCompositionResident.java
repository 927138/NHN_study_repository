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
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {

     @EmbeddedId
     private CompositionResidentPk compositionResidentPk;

     @MapsId("householdSerialNumber")
     @ManyToOne
     @JoinColumn(name = "household_serial_number")
     private HouseHold householdSerialNumber;

     @MapsId("residentSerialNumber")
     @ManyToOne
     @JoinColumn(name = "resident_serial_number")
     private Resident residentSerialNumber;

     @Temporal(TemporalType.TIMESTAMP)
     @Column(name = "report_date")
     private Date reportDate;

     @Column(name = "household_relationship_code")
     private String householdRelationshipCode;

     @Column(name = "household_composition_change_reason_code")
     private String householdCompositionChangeReasonCode;


     @NoArgsConstructor
     @AllArgsConstructor
     @EqualsAndHashCode
     @Setter @Getter
     @Embeddable
     public static class CompositionResidentPk implements Serializable {
          private Integer householdSerialNumber;
          private Integer residentSerialNumber;

     }

}
