package exam.certificationContext.userInterface;

import exam.certificationContext.application.CertificationApplicationService;
import exam.certificationContext.application.GenerateCertificationCommand;
import exam.certificationContext.domain.model.certification.CertificationId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CertificationController {

    private final CertificationApplicationService certificationApplicationService;

    @Autowired
    public CertificationController(CertificationApplicationService certificationApplicationService) {
        this.certificationApplicationService = certificationApplicationService;
    }

    @PostMapping("/certifications")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    CertificationDTO generate(@RequestBody GenerateCertificationCommand command) {
        final CertificationId certificationId = certificationApplicationService.generateCertification(command);
        return CertificationDTO.from(certificationId);
    }
}
