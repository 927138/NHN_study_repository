package com.nhnacademy.springjpa.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ResidentRegisterRequest {
     private Integer residentSerialNumber;
     private String name;
     private String residentRegistrationNumber;
     private String genderCode;
     private Date birthDate;
     private Date deathDate;
     private String birthPlaceCode;
     private String registrationBaseAddress;
     private String deathPlaceCode;
     private String deathPlaceAddress;
}
