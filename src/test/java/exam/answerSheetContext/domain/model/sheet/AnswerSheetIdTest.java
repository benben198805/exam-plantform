package exam.answerSheetContext.domain.model.sheet;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AnswerSheetIdTest {

    @Test
    void should_return_nextid() {
        // given

        // when
        AnswerSheetId answerSheetId = AnswerSheetId.nextId();

        // then
        assertNull(answerSheetId);

    }

    @Test
    void should_return_true_when_answer_sheet_with_same_values() {
        // given
        AnswerSheetId answerSheetId1 = new AnswerSheetId("1");
        AnswerSheetId answerSheetId2 = new AnswerSheetId("1");

        // when
        boolean result = answerSheetId1.equals(answerSheetId2);

        // then
        assertTrue(result);
    }

    @Test
    void should_return_true_for_same_answer_sheet() {
        // given
        AnswerSheetId answerSheetId = new AnswerSheetId("1");

        // when
        boolean result = answerSheetId.equals(answerSheetId);

        // then
        assertTrue(result);
    }

    @Test
    void should_return_false_when_answer_sheet_with_diff_values() {
        // given
        AnswerSheetId answerSheetId1 = new AnswerSheetId("1");
        AnswerSheetId answerSheetId2 = new AnswerSheetId("2");

        // when
        boolean result = answerSheetId1.equals(answerSheetId2);

        // then
        assertFalse(result);
    }

    @Test
    void should_return_false_when_diff_class() {
        // given
        AnswerSheetId answerSheetId1 = new AnswerSheetId("1");

        // when
        boolean result = answerSheetId1.equals(new Object());

        // then
        assertFalse(result);
    }

    @Test
    void should_return_false_for_null() {
        // given
        AnswerSheetId answerSheetId = new AnswerSheetId("1");

        // when
        boolean result = answerSheetId.equals(null);

        // then
        assertFalse(result);
    }

    @Test
    void should_return_hash_code() {
        // given
        AnswerSheetId answerSheetId = new AnswerSheetId("1");

        // when
        int result = answerSheetId.hashCode();

        // then
        assertEquals(result, Objects.hash("1"));
    }

    @Test
    void should_return_string() {
        // given
        AnswerSheetId answerSheetId = new AnswerSheetId("1");

        // when
        String result = answerSheetId.toString();

        // then
        assertEquals(result, "1");
    }
}