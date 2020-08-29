package exam.answerSheetContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssignAnswerSheetCommand {
    private String examinationId;
}