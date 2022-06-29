package pro.sky.java.course2.coursework2.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.coursework2.interfaces.QuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.coursework2.Constants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private MathQuestionService out;

    @Test
    void testingAddQuestion() {
        when(questionRepository.add(QUESTION1)).thenReturn(QUESTION1);
        assertEquals(out.add(QUESTION1), QUESTION1);
    }

    @Test
    void testingRemoveQuestion() {
        when(questionRepository.remove(QUESTION1)).thenReturn(QUESTION1);
        assertEquals(out.remove(QUESTION1), QUESTION1);
    }

    @Test
    void testingGetAllRepository() {
        when(questionRepository.getAll()).thenReturn(TEST_LIST);
        assertEquals(out.getAll(), TEST_LIST);
    }

    @Test
    void getRandomQuestion() {
        when(questionRepository.getQuestion(anyInt())).thenReturn(QUESTION2);
        assertEquals(out.getRandomQuestion(), QUESTION2);
    }//todo я так понимаю, когда есть вложенные методы, Mockito не работает? потому что этот тест не проходит, идея пишет "bound must be positive" bound это переменная из random.nextInt(maxValue)

    @Test
    void repositorySize() {
        when(questionRepository.questionListSize()).thenReturn(FIVE);
        assertEquals(out.repositorySize(), FIVE);
    }
}