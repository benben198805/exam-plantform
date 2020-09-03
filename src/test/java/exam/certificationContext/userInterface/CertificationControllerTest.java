package exam.certificationContext.userInterface;

import exam.certificationContext.application.CertificationApplicationService;
import exam.certificationContext.application.GenerateCertificationCommand;
import exam.certificationContext.domain.model.certification.CertificationId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CertificationControllerTest {
    @InjectMocks
    private CertificationController certificationController;
    @Mock
    private CertificationApplicationService certificationApplicationService;

    @Test
    void should_assign_answer_sheet() {
        // given
        GenerateCertificationCommand command = new GenerateCertificationCommand("courseId", "studentId");
        given(certificationApplicationService.generateCertification(any())).willReturn(new CertificationId("id"));

        // when
        CertificationDTO assign = certificationController.generate(command);

        // then
        assertEquals(assign.getUri(), "certification/id");
    }
}