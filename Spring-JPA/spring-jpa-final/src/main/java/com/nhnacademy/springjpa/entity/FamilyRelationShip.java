package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "family_relationship")
public class FamilyRelationShip {

     @EmbeddedId
     private FamilyPK familyPK;

     @MapsId("baseResidentSerialNumber")
     @ManyToOne
     @JoinColumn(name = "base_resident_serial_number", referencedColumnName ="resident_serial_number")
     private Resident baseResidentSerialNumber;

     @Column(name = "family_relationship_code")
     private String familyRelationshipCode;

     @NoArgsConstructor
     @AllArgsConstructor
     @EqualsAndHashCode
     @Setter @Getter
     @Embeddable
     public static class FamilyPK implements Serializable {
          @Column(name = "family_resident_serial_number")
          Integer familyResidentSerialNumber;

          @Column(name = "base_resident_serial_number")
          Integer baseResidentSerialNumber;
     }

}
