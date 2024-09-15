package pro.sky.java.course2.coursework2.repository;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.coursework2.exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.coursework2.exception.QuestionNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.coursework2.Constants.*;

class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository out = new JavaQuestionRepository();

    @Test
    void firstTestingAddQuestion() {
        assertEquals(out.add(QUESTION1), QUESTION1);
    }

    @Test
    void secondTestingAddQuestion() {
        out.add(QUESTION1);
        out.add(QUESTION2);
        assertEquals(out.getAll().size(), TWO);
    }

    @Test
    void firstTestingRemoveQuestion() {
        out.add(QUESTION1);
        assertEquals(out.remove(QUESTION1), QUESTION1);
    }

    @Test
    void secondTestingRemoveQuestion() {
        out.add(QUESTION2);
        out.remove(QUESTION2);
        assertEquals(out.getAll().size(), ZERO);
    }

    @Test
    void testingGetAll() {
        out.add(QUESTION1);
        out.add(QUESTION2);

        assertEquals(out.getAll(), TEST_LIST);
    }

    @Test
    void testingGetQuestion() {
        out.add(QUESTION1);
        out.add(QUESTION2);
        assertEquals(out.getQuestion(1), QUESTION2);
    }

    @Test
    void testingQuestionListSize() {
        out.add(QUESTION1);
        assertEquals(out.getAll().size(), ONE);
    }

    @Test
    void shouldThrowQuestionNotFoundExceptionWhenRemoveNotCreatedQuestion() {
        assertThrows(QuestionNotFoundException.class, () -> out.remove(QUESTION2));
    }

    @Test
    void firstShouldThrowQuestionAlreadyAddedExceptionWhenAddAlreadyAddedQuestion() {
        out.add(QUESTION1);
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(QUESTION1));
    }
}