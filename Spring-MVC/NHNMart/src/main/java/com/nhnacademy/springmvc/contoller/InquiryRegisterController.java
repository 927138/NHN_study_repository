package com.nhnacademy.springmvc.contoller;

import com.nhnacademy.springmvc.domain.Customer;
import com.nhnacademy.springmvc.domain.Inquiry;
import com.nhnacademy.springmvc.domain.InquiryRegisterRequest;
import com.nhnacademy.springmvc.domain.Role;
import com.nhnacademy.springmvc.exception.CustomerNotFoundException;
import com.nhnacademy.springmvc.exception.CustomerRolePoliceException;
import com.nhnacademy.springmvc.repository.CustomerRepository;
import com.nhnacademy.springmvc.repository.InquiryRepository;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cs")
public class InquiryRegisterController {

     private final InquiryRepository inquiryRepository;
     private final CustomerRepository customerRepository;

     private final String UPLOAD_DIR = "/Users/user/Desktop/uploadFile/";

     @GetMapping("/register")
     public String getInquiryRegisterForm() {
          return "inquiryForm";
     }


     @PostMapping("/register")
     public String getInquiryRegister(@ModelAttribute @Valid InquiryRegisterRequest inquiryRegisterRequest,
                                      @SessionAttribute(LoginController.LOGIN_SUCESSES) String cusId,
                                      BindingResult bindingResult) {

          if (bindingResult.hasErrors()) {
               throw new ValidationException(); // httpStatus : 400 BAD_REQUEST
          }

          List<String> imageList = new ArrayList<>();
          for (MultipartFile file : inquiryRegisterRequest.getImages()) {
               try {
                    String fileName = new String(file.getOriginalFilename().getBytes(StandardCharsets.ISO_8859_1),
                            StandardCharsets.UTF_8);

                    imageList.add(fileName);
                    file.transferTo(new File(UPLOAD_DIR, fileName));
               } catch (Exception e) {
                    log.debug(e.getMessage());
               }
          }

          Customer storageCus = customerRepository.getCustomer(cusId);
          if (Objects.isNull(storageCus)) {
               throw new CustomerNotFoundException();
          }
          if (storageCus.getRole() == Role.ADMIN) {
               throw new CustomerRolePoliceException();
          }

          SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String time = timeFormat.format(new Date(System.currentTimeMillis()));
          Inquiry inquiry = inquiryRepository.createInquiry(inquiryRegisterRequest.getTitle(),
                  inquiryRegisterRequest.getContent(), inquiryRegisterRequest.getCategorize(),
                  time, storageCus.getId(), imageList);
          inquiry.setAnswer(null);
          inquiry.setAnswerCheck(false);

          return "redirect:/cs/inquiry";
     }


     @ExceptionHandler({CustomerNotFoundException.class, CustomerRolePoliceException.class})
     @ResponseStatus(HttpStatus.NOT_FOUND)
     public String notFound(Exception ex, Model model) {
          model.addAttribute("exception", ex);
          return "error";
     }

}
