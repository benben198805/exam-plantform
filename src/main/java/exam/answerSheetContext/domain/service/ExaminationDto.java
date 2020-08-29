package exam.answerSheetContext.domain.service;

import exam.answerSheetContext.domain.model.sheet.AnswerSheet;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ExaminationDto {
    private String examinationId;
    private String studentId;
    private String teacherId;
    private List<AnswerSheet.BlankQuiz> blankQuizzes;
}
