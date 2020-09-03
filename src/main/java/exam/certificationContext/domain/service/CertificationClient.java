package exam.certificationContext.domain.service;

import exam.certificationContext.domain.model.certification.CertificationId;

public interface CertificationClient {
    CertificationDto generateCertification(CertificationId certificationId, String courseId, String owner);
}

