package com.nhnacademy.springjpa.domain;


import lombok.Data;

public interface FamilyRelationDto {

     Fk getFk();
     String getFamilyRelationshipCode();

     interface Fk{
          Integer getBaseSerialNumber();
          Integer familySerialNumber();
          
     }


}
