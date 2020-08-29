package exam.answerSheetContext.infrastructure;

import exam.answerSheetContext.domain.model.sheet.AnswerSheet;
import exam.answerSheetContext.domain.model.sheet.AnswerSheetId;
import exam.answerSheetContext.domain.model.sheet.AnswerSheetRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class MemoryAnswerSheetRepository implements AnswerSheetRepository {
    private Set<AnswerSheet> answerSheets = new HashSet<>();

    @Override
    public AnswerSheet find(AnswerSheetId answerSheetId) {
        return answerSheets.stream().filter(paper -> paper.getAnswerSheetId()
                .equals(answerSheetId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(AnswerSheet answerSheet) {
        answerSheets.add(answerSheet);
    }

    @Override
    public void update(AnswerSheet answerSheet) {
        AnswerSheet savedAnswerSheet = answerSheets.stream().filter(sheet -> Objects.equals(sheet.getAnswerSheetId(), answerSheet.getAnswerSheetId()))
                .findFirst().orElseThrow(NullPointerException::new);

        answerSheets.remove(savedAnswerSheet);
        answerSheets.add(answerSheet);
    }

}
