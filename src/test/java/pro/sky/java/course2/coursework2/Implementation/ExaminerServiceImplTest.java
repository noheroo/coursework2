package pro.sky.java.course2.coursework2.Implementation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.coursework2.Exception.AmountQuestionsMoreThanExistedException;
import pro.sky.java.course2.coursework2.Interface.QuestionService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.coursework2.Constants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void testingGetListOfQuestionWhenAddedOneQuestion() {
        when(questionService.questionListSize()).thenReturn(FIVE);
        when(questionService.getRandomQuestion()).thenReturn(QUESTION1);

        assertEquals(out.getQuestion(1), TEST_LIST_1);

        verify(questionService, times(1)).questionListSize();
        verify(questionService, times(1)).getRandomQuestion();
        //todo если меняю times(1) на only() тест проваливается (компилятор выдает: java.lang.NullPointerException: Cannot invoke "org.mockito.invocation.Invocation.getMock()" because "undesired" is null)почему не разобрался, в тесте ниже only() и never() работают адекватно

    }

    @Test
    void testingGetListOfQuestionWhenAddedTwoQuestion() {
        when(questionService.questionListSize()).thenReturn(TWO);
        when(questionService.getRandomQuestion()).thenReturn(QUESTION1).thenReturn(QUESTION2);

        assertEquals(out.getQuestion(2), TEST_LIST);

        verify(questionService, times(1)).questionListSize();
        verify(questionService, times(2)).getRandomQuestion();
    }

    @Test
    void shouldThrowAmountQuestionsMoreThanExistedExceptionWhenNeededQuantityQuestionMoreThanCreated() {
        when(questionService.questionListSize()).thenReturn(TWO);
        assertThrows(AmountQuestionsMoreThanExistedException.class, () -> out.getQuestion(FIVE));

        verify(questionService, never()).getRandomQuestion();
        verify(questionService, only()).questionListSize();
    }
}