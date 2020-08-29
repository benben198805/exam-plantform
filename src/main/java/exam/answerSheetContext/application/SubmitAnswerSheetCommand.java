package exam.answerSheetContext.application;

import exam.answerSheetContext.domain.model.sheet.AnswerSheet;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SubmitAnswerSheetCommand {
    private String studentId;
    private List<AnswerSheet.AnsweredSheetItem> answeredSheetItems;
}