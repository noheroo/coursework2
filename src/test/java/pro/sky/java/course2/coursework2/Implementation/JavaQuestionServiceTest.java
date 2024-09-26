package pro.sky.java.course2.coursework2.Implementation;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.coursework2.Data.Question;
import pro.sky.java.course2.coursework2.Exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.coursework2.Exception.QuestionNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.coursework2.Constants.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    @Test
    void firstTestingAddByQuestionAndAnswer() {
        assertEquals(out.add(TEST_QUESTION_1, TEST_ANSWER_1), QUESTION1);
    }

    @Test
    void secondTestingAddByQuestionAndAnswer() {
        out.add(TEST_QUESTION_1, TEST_ANSWER_1);
        assertEquals(out.questionListSize(),ONE );
    }

    @Test
    void firstTestingAddByQuestionObject() {
        assertEquals(out.add(QUESTION1),QUESTION1);
    }

    @Test
    void secondTestingAddByQuestionObject() {
        out.add(QUESTION1);
        out.add(QUESTION2);
        assertEquals(out.questionListSize(),TWO );
    }

    @Test
    void firstTestingRemoveByQuestionAndAnswer() {
        out.add(TEST_QUESTION_1, TEST_ANSWER_1);
        assertEquals(out.remove(TEST_QUESTION_1, TEST_ANSWER_1), QUESTION1);
    }
    @Test
    void secondTestingRemoveByQuestionAndAnswer() {
        out.add(TEST_QUESTION_1, TEST_ANSWER_1);
        out.remove(TEST_QUESTION_1, TEST_ANSWER_1);
        assertEquals(out.questionListSize(), ZERO);
    }

    @Test
    void testingGetAll() {
        out.add(QUESTION1);
        out.add(QUESTION2);

        assertEquals(out.getAll(),TEST_LIST);
    }

    @Test
    void questionListSize() {
        out.add(QUESTION1);
        assertEquals(out.questionListSize(),ONE);
    }

    @Test
    void shouldThrowQuestionNotFoundExceptionWhenRemoveNotCreatedQuestion() {
        assertThrows(QuestionNotFoundException.class, () -> out.remove(TEST_QUESTION_2,TEST_ANSWER_2));
    }

    @Test
    void firstShouldThrowQuestionAlreadyAddedExceptionWhenAddAlreadyAddedQuestion() {
        out.add(QUESTION1);
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(QUESTION1));
    }

    @Test
    void secondShouldThrowQuestionAlreadyAddedExceptionWhenAddAlreadyAddedQuestion() {
        out.add(QUESTION1);
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(TEST_QUESTION_1,TEST_ANSWER_1));
    }
}