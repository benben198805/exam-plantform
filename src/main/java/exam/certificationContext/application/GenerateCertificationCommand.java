package exam.certificationContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenerateCertificationCommand {
    private String courseId;
    private String studentId;
}