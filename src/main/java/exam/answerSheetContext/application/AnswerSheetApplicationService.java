package exam.answerSheetContext.application;

import exam.answerSheetContext.domain.model.sheet.AnswerSheet;
import exam.answerSheetContext.domain.model.sheet.AnswerSheetId;
import exam.answerSheetContext.domain.service.ExaminationClient;
import exam.answerSheetContext.domain.service.ExaminationDto;
import exam.answerSheetContext.infrastructure.MemoryAnswerSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerSheetApplicationService {
    private MemoryAnswerSheetRepository answerSheetRepository;
    private ExaminationClient examinationClient;

    @Autowired
    public AnswerSheetApplicationService(MemoryAnswerSheetRepository answerSheetRepository) {
        this.answerSheetRepository = answerSheetRepository;
    }

    public AnswerSheetId assignAnswerSheet(AssignAnswerSheetCommand command) {
        final String examinationId = command.getExaminationId();
        ExaminationDto examinationDto = examinationClient.getExaminationById(examinationId);
        final AnswerSheetId answerSheetId = AnswerSheetId.nextId();

        AnswerSheet answerSheet = AnswerSheet.assignBlankAnswerSheet(answerSheetId, examinationDto.getStudentId(), examinationDto.getExaminationId(), examinationDto.getTeacherId(), examinationDto.getBlankQuizzes());

        answerSheetRepository.save(answerSheet);

        return answerSheet.getAnswerSheetId();
    }

    public void submitAnswerSheet(String answerSheetId, SubmitAnswerSheetCommand command) {
        final AnswerSheet answerSheet = answerSheetRepository.find(new AnswerSheetId(answerSheetId));

        final String studentId = command.getStudentId();
        final List<AnswerSheet.AnsweredSheetItem> teacherId = command.getAnsweredSheetItems();

        answerSheet.submitAnswerItems(studentId, teacherId);

        answerSheetRepository.update(answerSheet);
    }
}
