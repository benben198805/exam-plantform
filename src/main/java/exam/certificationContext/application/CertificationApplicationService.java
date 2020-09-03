package exam.certificationContext.application;

import exam.certificationContext.domain.model.certification.Certification;
import exam.certificationContext.domain.model.certification.CertificationId;
import exam.certificationContext.domain.service.*;
import exam.certificationContext.infrastructure.MemoryCertificationSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificationApplicationService {
    private MemoryCertificationSheetRepository certificationSheetRepository;
    private StudentClient studentClient;
    private CourseClient courseClient;
    private CertificationClient certificationClient;

    @Autowired
    public CertificationApplicationService(MemoryCertificationSheetRepository certificationSheetRepository, StudentClient studentClient, CourseClient courseClient, CertificationClient certificationClient) {
        this.certificationSheetRepository = certificationSheetRepository;
        this.studentClient = studentClient;
        this.courseClient = courseClient;
        this.certificationClient = certificationClient;
    }

    public CertificationId generateCertification(GenerateCertificationCommand command) {
        final String studentId = command.getStudentId();
        StudentDto studentDto = studentClient.getStudentDto(studentId);

        final String courseId = command.getCourseId();
        CourseDto courseDto = courseClient.getCourseDto(courseId);

        final CertificationId certificationId = CertificationId.nextId();

        CertificationDto certificationDto = certificationClient.generateCertification(certificationId, courseDto.getCourseName(), studentDto.getStudentName());

        Certification certification = Certification.generateCertification(certificationId, courseId, studentId, certificationDto.getCertificationNumber());

        certificationSheetRepository.save(certification);

        return certification.getCertificationId();
    }
}
