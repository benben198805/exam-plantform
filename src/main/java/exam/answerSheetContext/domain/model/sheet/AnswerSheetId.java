package exam.answerSheetContext.domain.model.sheet;

import exam.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class AnswerSheetId implements ValueObject<AnswerSheetId> {
    private String id;

    public static AnswerSheetId nextId() {
        return null;
    }

    @Override
    public boolean sameValueAs(AnswerSheetId other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerSheetId paperId = (AnswerSheetId) o;
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
