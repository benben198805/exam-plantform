package exam.certificationContext.infrastructure;

import exam.certificationContext.domain.model.certification.Certification;
import exam.certificationContext.domain.model.certification.CertificationId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
class MemoryCertificationSheetRepositoryTest {
    @InjectMocks
    private MemoryCertificationSheetRepository memoryCertificationSheetRepository;

    @Test
    void should_find_answer_sheet_by_id() {
        // given
        CertificationId certificationId = new CertificationId("id");
        Certification certification = Certification.generateCertification(certificationId, "courseId", "studentId", "certificationNumber");
        memoryCertificationSheetRepository.save(certification);

        // when
        Certification result = memoryCertificationSheetRepository.find(certificationId);

        // then
        assertEquals(result, certification);
    }
}