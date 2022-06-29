package pro.sky.java.course2.coursework2.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
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

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void testingGetListOfQuestionWhenAddedOneQuestion() {
        when(javaQuestionService.repositorySize()).thenReturn(FIVE);
        when(mathQuestionService.repositorySize()).thenReturn(FIVE);
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION1);
        when(mathQuestionService.getRandomQuestion()).thenReturn(QUESTION1);

        assertEquals(out.getQuestions(1), TEST_SET_1);

        verify(javaQuestionService, times(2)).repositorySize();
        verify(mathQuestionService, times(2)).repositorySize();
        verify(javaQuestionService, atMost(1)).getRandomQuestion();
        verify(mathQuestionService, atMost(1)).getRandomQuestion();

    }

    @Test
    void testingOrderGetListOfQuestionWhenAddedOneQuestion() {
        when(javaQuestionService.repositorySize()).thenReturn(FIVE);
        when(mathQuestionService.repositorySize()).thenReturn(FIVE);
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION1);
        when(mathQuestionService.getRandomQuestion()).thenReturn(QUESTION1);

        assertEquals(out.getQuestions(1), TEST_SET_1);

        InOrder inOrder = inOrder(javaQuestionService, mathQuestionService);

        inOrder.verify(javaQuestionService, times(1)).repositorySize();
        inOrder.verify(mathQuestionService, times(1)).repositorySize();
        inOrder.verify(javaQuestionService, atMost(1)).getRandomQuestion();
        inOrder.verify(mathQuestionService, atMost(1)).getRandomQuestion();

    }

//    @Test
//    void testingGetListOfQuestionWhenAddedTwoQuestion() {
//        when(questionService.questionListSize()).thenReturn(TWO);
//        when(questionService.getRandomQuestion()).thenReturn(QUESTION1).thenReturn(QUESTION2);
//
//        assertEquals(out.getQuestion(2), TEST_SET_2);
//
//        verify(questionService, times(1)).questionListSize();
//        verify(questionService, times(2)).getRandomQuestion();
//    }
//    @Test
//
//    void testingOrderGetListOfQuestionWhenAddedTwoQuestion() {
//        when(questionService.questionListSize()).thenReturn(TWO);
//        when(questionService.getRandomQuestion()).thenReturn(QUESTION1).thenReturn(QUESTION2);
//
//        assertEquals(out.getQuestion(2), TEST_SET_2);
//
//        InOrder inOrder = inOrder(questionService);
//
//        inOrder.verify(questionService, times(1)).questionListSize();
//        inOrder.verify(questionService, times(2)).getRandomQuestion();
//    }

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