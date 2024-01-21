package com.nhnacademy.springjpa.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resident")
public class Resident {

     @Id
     @Column(name = "resident_serial_number")
     private Integer residentSerialNumber;

     private String name;

     @Column(name = "resident_registration_number")
     private String residentRegistrationNumber;

     @Column(name = "gender_code")
     private String genderCode;

     @Temporal(value = TemporalType.TIMESTAMP)
     @Column(name = "birth_date")
     private Date birthDate;

     @Temporal(value = TemporalType.TIMESTAMP)
     @Column(name = "death_date")
     private Date deathDate;

     @Column(name = "birth_place_code")
     private String birthPlaceCode;

     @Column(name = "registration_base_address")
     private String registrationBaseAddress;

     @Column(name = "death_place_code")
     private String deathPlaceCode;

     @Column(name = "death_place_address")
     private String deathPlaceAddress;

     @OneToMany(mappedBy = "residentSerialNumber", fetch = FetchType.EAGER)
     List<CertificateIssue> certificateIssues;
}
