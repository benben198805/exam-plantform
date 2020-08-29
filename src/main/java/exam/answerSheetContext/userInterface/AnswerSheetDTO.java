package exam.answerSheetContext.userInterface;

import exam.answerSheetContext.domain.model.sheet.AnswerSheetId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerSheetDTO {
    private String uri;

    public static AnswerSheetDTO from(AnswerSheetId answerSheetId) {
        return new AnswerSheetDTO("answerSheet/" + answerSheetId);
    }
}
