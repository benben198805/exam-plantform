package exam.certificationContext.infrastructure;

import exam.certificationContext.domain.model.certification.Certification;
import exam.certificationContext.domain.model.certification.CertificationId;
import exam.certificationContext.domain.model.certification.CertificationSheetRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MemoryCertificationSheetRepository implements CertificationSheetRepository {
    private Set<Certification> certifications = new HashSet<>();

    // for test
    public Certification find(CertificationId certificationId) {
        return certifications.stream().filter(certification -> certification.getCertificationId()
                .equals(certificationId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }


    @Override
    public void save(Certification certification) {
        certifications.add(certification);
    }

}
