package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Value;

@Value
public class AnswerRequest {
     @NotBlank
     @Size(max = 40000)
     String content;
}
