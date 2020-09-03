package exam.certificationContext.userInterface;

import exam.certificationContext.domain.model.certification.CertificationId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CertificationDTO {
    private String uri;

    public static CertificationDTO from(CertificationId certificationId) {
        return new CertificationDTO("certification/" + certificationId);
    }
}
