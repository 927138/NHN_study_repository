package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Getter
@Setter
public class StudentRequest {
     @NotBlank
     String name;

     @Email
     String email;

     @Min(0)
     @Max(100)
     int score;

     @NotBlank
     @Length(max = 200)
     String comment;

}

//@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)

