package exam.certificationContext.domain.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CertificationDto {
    private String certificationNumber;
    private String courseId;
    private String courseName;
}
