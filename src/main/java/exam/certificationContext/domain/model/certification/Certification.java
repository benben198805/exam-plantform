package exam.certificationContext.domain.model.certification;

import exam.shared.Entity;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(of = {"certificationId"})
public class Certification implements Entity<Certification> {
    private CertificationId certificationId;
    private String courseId;
    private String studentId;
    private String certificationNumber;

    private LocalDateTime createTime;

    private Certification(CertificationId certificationId, String courseId, String studentId, String certificationNumber) {
        this.certificationId = certificationId;
        this.courseId = courseId;
        this.studentId = studentId;
        this.certificationNumber = certificationNumber;
    }

    public static Certification generateCertification(CertificationId certificationId, String courseId, String studentId, String certificationNumber) {
        Certification certification = new Certification(certificationId, courseId, studentId, certificationNumber);
        certification.createTime = LocalDateTime.now();
        return certification;
    }

    public CertificationId getCertificationId() {
        return certificationId;
    }

    @Override
    public boolean sameIdentityAs(Certification other) {
        return certificationId.sameValueAs(other.getCertificationId());
    }

}
