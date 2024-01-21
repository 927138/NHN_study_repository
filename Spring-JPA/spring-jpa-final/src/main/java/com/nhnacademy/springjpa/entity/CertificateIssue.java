package com.nhnacademy.springjpa.entity;


import java.io.Serializable;
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
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "certificate_issue")
public class CertificateIssue {

     @Id
     @Column(name = "certificate_confirmation_number")
     private Long certificateConfirmationNumber;

     @Temporal(TemporalType.TIMESTAMP)
     @Column(name = "certificate_issue_date")
     private Date certificateIssueDate;

     @ManyToOne
     @JoinColumn(name = "resident_serial_number")
     private Resident residentSerialNumber;

     @Column(name = "certificate_type_code")
     private String certificateTypeCode;



}
