package com.nhnacademy.springjpa.domain;

import java.util.Date;
import lombok.Data;


@Data
public class ResidentUpdateDeathRequest {
     Date deathDate;
     String deathPlaceCode;
     String deathPlaceAddress;
}
