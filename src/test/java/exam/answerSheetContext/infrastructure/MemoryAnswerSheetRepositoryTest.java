package exam.answerSheetContext.infrastructure;

import exam.answerSheetContext.domain.model.sheet.AnswerSheet;
import exam.answerSheetContext.domain.model.sheet.AnswerSheetId;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MemoryAnswerSheetRepositoryTest {

    @InjectMocks
    private MemoryAnswerSheetRepository memoryAnswerSheetRepository;

    @Test
    void should_find_answer_sheet_by_id() {
        // given
        AnswerSheetId answerSheetId = new AnswerSheetId("answerSheetId");
        AnswerSheet answerSheet = AnswerSheet.assignBlankAnswerSheet(answerSheetId, "sid", "eid", "tid", Lists.emptyList());
        memoryAnswerSheetRepository.save(answerSheet);

        // when
        AnswerSheet result = memoryAnswerSheetRepository.find(answerSheetId);

        // then
        assertEquals(result, answerSheet);
    }

    @Test
    void should_throw_exception_when_find_answer_sheet_by_non_exist_id() {
        // given
        AnswerSheetId answerSheetId = new AnswerSheetId("answerSheetId");

        // when
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> memoryAnswerSheetRepository.find(answerSheetId));

        // then
        assertNull(exception.getMessage());
    }

    @Test
    void should_save_answer_sheet() {
        // given
        AnswerSheetId answerSheetId = new AnswerSheetId("1");
        AnswerSheet answerSheet = AnswerSheet.assignBlankAnswerSheet(answerSheetId, "sid", "eid", "tid", Lists.emptyList());
        // when
        memoryAnswerSheetRepository.save(answerSheet);
        AnswerSheet result = memoryAnswerSheetRepository.find(answerSheetId);

        // then
        assertEquals(result.getAnswerSheetId(), answerSheetId);
    }

    @Test
    void should_update_answer_sheet() {
        // given
        AnswerSheetId answerSheetId = new AnswerSheetId("1");
        AnswerSheet answerSheet = AnswerSheet.assignBlankAnswerSheet(answerSheetId, "sid", "eid", "tid", Lists.emptyList());
        memoryAnswerSheetRepository.save(answerSheet);

        // when
        AnswerSheet updatedAnswerSheet = AnswerSheet.assignBlankAnswerSheet(answerSheetId, "sid-1", "eid-1", "tid", Lists.emptyList());
        memoryAnswerSheetRepository.update(updatedAnswerSheet);
        AnswerSheet result = memoryAnswerSheetRepository.find(answerSheetId);

        // then
        assertEquals(result, answerSheet);
    }

    @Test
    void should_throw_exception_when_update_answer_sheet_with_non_exist_id() {
        // given
        AnswerSheetId answerSheetId = new AnswerSheetId("1");
        AnswerSheet answerSheet = AnswerSheet.assignBlankAnswerSheet(answerSheetId, "sid", "eid", "tid", Lists.emptyList());

        // when
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> memoryAnswerSheetRepository.update(answerSheet));

        // then
        assertNull(exception.getMessage());
    }
}