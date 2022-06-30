package pro.sky.java.course2.coursework2.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.coursework2.interfaces.QuestionRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.coursework2.Constants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private JavaQuestionService out;

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
        when(questionRepository.getQuestion(Math.abs(anyInt()))).thenReturn(QUESTION2);
        when(questionRepository.questionListSize()).thenReturn(ONE);
        assertEquals(out.getRandomQuestion(),QUESTION2);
    }

    @Test
    void repositorySize() {
        when(questionRepository.questionListSize()).thenReturn(FIVE);
        assertEquals(out.repositorySize(),FIVE);
    }


}