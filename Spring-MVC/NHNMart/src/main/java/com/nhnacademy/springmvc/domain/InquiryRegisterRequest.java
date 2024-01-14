package com.nhnacademy.springmvc.domain;

import java.util.List;
import javax.validation.constraints.NotBlank;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

@Value
public class InquiryRegisterRequest {
     @NotBlank
     String title;

     List<MultipartFile> images;

     @NotBlank
     String content;
     Category categorize;

}
