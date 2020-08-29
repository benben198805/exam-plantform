package exam.answerSheetContext.domain.model.sheet;

import exam.shared.Entity;
import exam.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@EqualsAndHashCode(of = {"answerSheetId"})
public class AnswerSheet implements Entity<AnswerSheet> {
    private AnswerSheetId answerSheetId;
    private String studentId;
    private String examinationId;
    private String certificationId;
    private String teacherId;

    private List<AnsweredSheetItem> answeredSheetItems;
    private List<BlankQuiz> blankQuizzes;

    private LocalDateTime startTime;
    private LocalDateTime submitTime;

    private AnswerSheet(AnswerSheetId answerSheetId, String studentId, String examinationId, String teacherId, List<BlankQuiz> blankQuizzes) {
        this.answerSheetId = answerSheetId;
        this.studentId = studentId;
        this.examinationId = examinationId;
        this.teacherId = teacherId;
        this.blankQuizzes = blankQuizzes;
    }

    public static AnswerSheet assignBlankAnswerSheet(AnswerSheetId answerSheetId, String studentId, String examinationId, String teacherId, List<BlankQuiz> blankQuizzes) {
        AnswerSheet answerSheet = new AnswerSheet(answerSheetId, studentId, examinationId, teacherId, blankQuizzes);
        answerSheet.startTime = LocalDateTime.now();
        return answerSheet;
    }

    public AnswerSheetId getAnswerSheetId() {
        return answerSheetId;
    }

    @Override
    public boolean sameIdentityAs(AnswerSheet other) {
        return answerSheetId.sameValueAs(other.getAnswerSheetId());
    }

    public void submitAnswerItems(String studentId, List<AnsweredSheetItem> answeredSheetItems) {
        if (Objects.equals(this.studentId, studentId)) {
            throw new IllegalStudentIdException();
        }
        this.answeredSheetItems = answeredSheetItems;
        this.submitTime = LocalDateTime.now();
    }

    @Getter
    @AllArgsConstructor
    public static class BlankQuiz implements ValueObject<BlankQuiz> {
        private int number;
        private int score;
        private String question;
        private String referenceAnswer;

        @Override
        public boolean sameValueAs(BlankQuiz other) {
            return false;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class AnsweredSheetItem implements ValueObject<AnsweredSheetItem> {
        private int number;
        private String answer;

        @Override
        public boolean sameValueAs(AnsweredSheetItem other) {
            return false;
        }
    }
}
