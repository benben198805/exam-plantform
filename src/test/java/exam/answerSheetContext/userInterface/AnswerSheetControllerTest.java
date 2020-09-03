package exam.answerSheetContext.userInterface;

import exam.answerSheetContext.application.AnswerSheetApplicationService;
import exam.answerSheetContext.application.AssignAnswerSheetCommand;
import exam.answerSheetContext.application.SubmitAnswerSheetCommand;
import exam.answerSheetContext.domain.model.sheet.AnswerSheetId;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnswerSheetControllerTest {
    @InjectMocks
    private AnswerSheetController answerSheetController;
    @Mock
    private AnswerSheetApplicationService answerSheetApplicationService;

    @Test
    void should_assign_answer_sheet() {
        // given
        AssignAnswerSheetCommand command = new AssignAnswerSheetCommand("id");
        given(answerSheetApplicationService.assignAnswerSheet(any())).willReturn(new AnswerSheetId("id"));

        // when
        AnswerSheetDTO assign = answerSheetController.assign(command);

        // then
        assertEquals(assign.getUri(), "answerSheet/id");
    }

    @Test
    void should_submit_answer_sheet() {
        // given
        SubmitAnswerSheetCommand command = new SubmitAnswerSheetCommand("id", Lists.emptyList());
        doNothing().when(answerSheetApplicationService).submitAnswerSheet(any(), any());

        // when
        answerSheetController.submit("id", command);

        // then
        verify(answerSheetApplicationService, times(1)).submitAnswerSheet(any(), any());
    }
}