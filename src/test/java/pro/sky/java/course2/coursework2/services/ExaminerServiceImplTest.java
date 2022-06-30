package pro.sky.java.course2.coursework2.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.coursework2.exception.QuestionsMoreThanExistedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.coursework2.Constants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @Mock
    private MathQuestionService mathQuestionService;

    private ExaminerServiceImpl out;

    @BeforeEach
    public void initOut() {
        out = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
    }

    @Test
    void testingGetListOfQuestionWhenAddedOneMathQuestion() {
        when(javaQuestionService.repositorySize()).thenReturn(ZERO);
        when(mathQuestionService.repositorySize()).thenReturn(ONE);

        when(mathQuestionService.getRandomQuestion()).thenReturn(QUESTION1);

        assertEquals(out.getQuestions(1), TEST_SET_1);

        verify(javaQuestionService, never()).getRandomQuestion();
        verify(mathQuestionService, times(1)).getRandomQuestion();
    }

    @Test
    void testingGetListOfQuestionWhenAddedOneJavaQuestion() {
        when(javaQuestionService.repositorySize()).thenReturn(ONE);
        when(mathQuestionService.repositorySize()).thenReturn(ZERO);
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION1);

        assertEquals(out.getQuestions(1), TEST_SET_1);

        verify(javaQuestionService, times(1)).getRandomQuestion();
        verify(mathQuestionService, never()).getRandomQuestion();
    }

    @Test
    void testingOrderGetListOfQuestionWhenAddedOneJavaAndOneMathQuestion() {
        when(javaQuestionService.repositorySize()).thenReturn(ONE);
        when(mathQuestionService.repositorySize()).thenReturn(ONE);
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION1);
        when(mathQuestionService.getRandomQuestion()).thenReturn(QUESTION2);

        assertEquals(out.getQuestions(2), TEST_SET_2);

        verify(javaQuestionService, times(1)).getRandomQuestion();
        verify(mathQuestionService, times(1)).getRandomQuestion();
    }

    @Test
    void testingOrderGetListOfQuestionWhenAddedTwoMathQuestion() {
        when(javaQuestionService.repositorySize()).thenReturn(ZERO);
        when(mathQuestionService.repositorySize()).thenReturn(TWO);
        when(mathQuestionService.getRandomQuestion()).thenReturn(QUESTION1, QUESTION2);

        assertEquals(out.getQuestions(2), TEST_SET_2);

        verify(mathQuestionService, times(2)).getRandomQuestion();
        verify(javaQuestionService, never()).getRandomQuestion();
    }

    @Test
    void shouldThrowAmountQuestionsMoreThanExistedExceptionWhenNeededQuantityQuestionMoreThanCreated() {
        when(javaQuestionService.repositorySize()).thenReturn(TWO);
        when(mathQuestionService.repositorySize()).thenReturn(TWO);
        assertThrows(QuestionsMoreThanExistedException.class, () -> out.getQuestions(FIVE));

        verify(javaQuestionService, never()).getRandomQuestion();
        verify(mathQuestionService, never()).getRandomQuestion();
        verify(javaQuestionService, only()).repositorySize();
        verify(mathQuestionService, only()).repositorySize();
    }
}