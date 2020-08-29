package exam.answerSheetContext.domain.model.sheet;

public interface AnswerSheetRepository {
    AnswerSheet find(AnswerSheetId answerSheetId);

    void save(AnswerSheet answerSheet);

    void update(AnswerSheet answerSheet);
}
