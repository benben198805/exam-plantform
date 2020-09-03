package exam.certificationContext.userInterface;

import exam.certificationContext.domain.model.certification.CertificationId;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CertificationDTOTest {

    @Test
    void should_get_new_answer_sheet_dto() {
        // given
        CertificationDTO certificationDTO = new CertificationDTO("uri");

        // when
        CertificationDTO result = CertificationDTO.from(new CertificationId("1"));

        // then
        assertThat(result.getUri(), is("certification/1"));
    }
}