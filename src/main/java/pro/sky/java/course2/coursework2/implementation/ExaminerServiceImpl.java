package pro.sky.java.course2.coursework2.implementation;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.exception.AmountQuestionsMoreThanExistedException;
import pro.sky.java.course2.coursework2.interfaces.ExaminerService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        validateAmount(amount);
        Set<Question> listForExam = new HashSet<>();
        while (listForExam.size() < amount) {
            Question questionObj = questionService.getRandomQuestion();
            listForExam.add(questionObj);
        }
        return listForExam;
    }


    private void validateAmount(int amount) {
        if (amount > questionService.questionListSize()) {
            throw new AmountQuestionsMoreThanExistedException("Запрошено больше вопросов, чем есть");
        }
    }
}
