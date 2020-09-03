package exam.certificationContext.domain.model.certification;

import exam.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class CertificationId implements ValueObject<CertificationId> {
    private String id;

    public static CertificationId nextId() {
        return null;
    }

    @Override
    public boolean sameValueAs(CertificationId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertificationId paperId = (CertificationId) o;
        return Objects.equals(id, paperId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
