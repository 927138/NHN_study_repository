package com.nhnacademy.springjpa.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BirthDeathRegisterRequest {
     private Integer reportResidentSerialNumber;
     private String birthDeathTypeCode;

     private Date birthDeathReportDate;
     private String birthReportQualificationsCode;
     private String deathReportQualificationsCode;
     private String emailAddress;
     private String phoneNumber;
}
