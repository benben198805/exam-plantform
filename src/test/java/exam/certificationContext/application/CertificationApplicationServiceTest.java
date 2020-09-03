package exam.certificationContext.application;

import exam.certificationContext.domain.model.certification.CertificationId;
import exam.certificationContext.domain.service.*;
import exam.certificationContext.infrastructure.MemoryCertificationSheetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CertificationApplicationServiceTest {
    @InjectMocks
    private CertificationApplicationService certificationApplicationService;
    @Mock
    private MemoryCertificationSheetRepository certificationSheetRepository;
    @Mock
    private StudentClient studentClient;
    @Mock
    private CourseClient courseClient;
    @Mock
    private CertificationClient certificationClient;

    @Test
    void should_generate_certification() {
        // given
        GenerateCertificationCommand command = new GenerateCertificationCommand("courseId", "studentId");
        given(studentClient.getStudentDto(any())).willReturn(new StudentDto("studentId", "studentName"));
        given(courseClient.getCourseDto(any())).willReturn(new CourseDto("courseId", "courseName"));
        given(certificationClient.generateCertification(any(), any(), any())).willReturn(new CertificationDto("certificationNumber", "courseId", "studentId"));
        doNothing().when(certificationSheetRepository).save(any());

        // when
        CertificationId certificationId = certificationApplicationService.generateCertification(command);

        // then
        assertNull(certificationId);
        verify(certificationSheetRepository, times(1)).save(any());
    }
}