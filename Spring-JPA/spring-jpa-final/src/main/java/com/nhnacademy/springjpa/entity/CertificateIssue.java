package com.nhnacademy.springjpa.entity;


import java.io.Serializable;
import java.util.Date;
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
@Table(name = "certificate_issue")
public class CertificateIssue {

     @EmbeddedId
     private CertificatePk certificatePk;

     @Temporal(TemporalType.TIMESTAMP)
     private Date certificate_issue_date;

     @MapsId("resident_serial_number")
     @ManyToOne
     @JoinColumn(name = "resident_serial_number")
     private Resident resident_serial_number;

     private String certificate_type_code;


     @NoArgsConstructor
     @AllArgsConstructor
     @EqualsAndHashCode
     @Setter @Getter
     @Embeddable
     public static class CertificatePk implements Serializable {
          Long certificate_confirmation_number;
          Integer resident_serial_number;
     }
}
