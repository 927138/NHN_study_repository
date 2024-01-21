package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Getter @Setter
@Table(name = "birth_death_report_resident")
public class BirthDeathReportResident {
     @EmbeddedId
     private BirthDeathPK birthDeathPK;

     @MapsId("residentSerialNumber")
     @JoinColumn(name = "resident_serial_number")
     @ManyToOne
     private Resident residentSerialNumber;

     @Temporal(TemporalType.TIMESTAMP)
     @Column(name = "birth_death_report_date")
     private Date birthDeathReportDate;

     @Column(name = "birth_report_qualifications_code")
     private String birthReportQualificationsCode;

     @Column(name = "death_report_qualifications_code")
     private String deathReportQualificationsCode;

     @Column(name = "email_address")
     private String emailAddress;

     @Column(name = "phone_number")
     private String phoneNumber;


     @NoArgsConstructor
     @AllArgsConstructor
     @EqualsAndHashCode
     @Setter @Getter
     @Embeddable
     public static class BirthDeathPK implements Serializable {
          @Column(name = "report_resident_serial_number")
          private Integer reportResidentSerialNumber;

          @Column(name = "birth_death_type_code")
          private String birthDeathTypeCode;

          @Column(name = "resident_serial_number")
          private Integer residentSerialNumber;
     }

}
