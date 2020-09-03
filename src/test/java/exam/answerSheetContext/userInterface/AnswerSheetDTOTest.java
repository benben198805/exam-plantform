package exam.answerSheetContext.userInterface;

import exam.answerSheetContext.domain.model.sheet.AnswerSheetId;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AnswerSheetDTOTest {

    @Test
    void should_get_new_answer_sheet_dto() {
        // given
        AnswerSheetDTO answerSheetDTO = new AnswerSheetDTO("uri");

        // when
        AnswerSheetDTO result = answerSheetDTO.from(new AnswerSheetId("1"));

        // then
        assertThat(result.getUri(), is("answerSheet/1"));
    }
}