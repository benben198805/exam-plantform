package exam.certificationContext.domain.model.certification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CertificationTest {

    @Test
    void should_generate_certification() {
        // given
        CertificationId certificationId = new CertificationId("id");

        // when
        Certification certification = Certification.generateCertification(certificationId, "courseId", "studentId", "certificationNumber");

        // then
        assertEquals(certification.getCertificationId(), certificationId);
    }

    @Test
    void should_return_true_when_same_certification() {
        // given
        CertificationId certificationId = new CertificationId("id");

        // when
        Certification certification1 = Certification.generateCertification(certificationId, "courseId", "studentId", "certificationNumber");
        Certification certification2 = Certification.generateCertification(certificationId, "cId-1", "studentId", "certificationNumber");

        // then
        assertTrue(certification1.sameIdentityAs(certification2));
    }

    @Test
    void should_return_false_when_same_certification() {
        // given
        CertificationId certificationId1 = new CertificationId("id-1");
        Certification certification1 = Certification.generateCertification(certificationId1, "cId-1", "studentId", "certificationNumber");
        CertificationId certificationId2 = new CertificationId("id-2");
        Certification certification2 = Certification.generateCertification(certificationId2, "cId-2", "studentId", "certificationNumber");

        // when

        // then
        assertFalse(certification1.sameIdentityAs(certification2));
    }
}