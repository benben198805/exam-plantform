package exam.certificationContext.domain.model.certification;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CertificationTest {

    @Test
    void should_return_nextid() {
        // given

        // when
        CertificationId certificationId = CertificationId.nextId();

        // then
        assertNull(certificationId);

    }

    @Test
    void should_return_true_when_certification_with_same_values() {
        // given
        CertificationId certificationId1 = new CertificationId("1");
        CertificationId certificationId2 = new CertificationId("1");

        // when
        boolean result = certificationId1.equals(certificationId2);

        // then
        assertTrue(result);
    }

    @Test
    void should_return_true_for_same_certification() {
        // given
        CertificationId certificationId = new CertificationId("1");

        // when
        boolean result = certificationId.equals(certificationId);

        // then
        assertTrue(result);
    }

    @Test
    void should_return_false_when_certification_with_diff_values() {
        // given
        CertificationId certificationId = new CertificationId("1");
        CertificationId answerSheetId2 = new CertificationId("2");

        // when
        boolean result = certificationId.equals(answerSheetId2);

        // then
        assertFalse(result);
    }

    @Test
    void should_return_false_when_diff_class() {
        // given
        CertificationId certificationId = new CertificationId("1");

        // when
        boolean result = certificationId.equals(new Object());

        // then
        assertFalse(result);
    }

    @Test
    void should_return_false_for_null() {
        // given
        CertificationId certificationId = new CertificationId("1");

        // when
        boolean result = certificationId.equals(null);

        // then
        assertFalse(result);
    }

    @Test
    void should_return_hash_code() {
        // given
        CertificationId certificationId = new CertificationId("1");

        // when
        int result = certificationId.hashCode();

        // then
        assertEquals(result, Objects.hash("1"));
    }

    @Test
    void should_return_string() {
        // given
        CertificationId certificationId = new CertificationId("1");

        // when
        String result = certificationId.toString();

        // then
        assertEquals(result, "1");
    }
}