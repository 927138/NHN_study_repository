package com.nhnacademy.springjpa.domain;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ResidentCertificateIssueDto {
     String getName();

     List<CertificateIssueDto> getCertificateIssues();
     interface CertificateIssueDto{
          String getCertificateTypeCode();
          Long getCertificateConfirmationNumber();
     }
}
