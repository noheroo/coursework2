package pro.sky.java.course2.coursework2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.exception.QuestionsMoreThanExistedException;
import pro.sky.java.course2.coursework2.interfaces.ExaminerService;
import pro.sky.java.course2.coursework2.interfaces.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Random random = new Random();

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        validateAmount(amount);
        int quantityForJava = quantityForJava(amount);
        Set<Question> listForExam = new HashSet<>(amount);

        while (listForExam.size() < quantityForJava) {
            Question questionJava = javaQuestionService.getRandomQuestion();
            listForExam.add(questionJava);
        }
        while (listForExam.size() < amount) {
            Question questionMath = mathQuestionService.getRandomQuestion();
            listForExam.add(questionMath);
        }
        return listForExam;
    }


    private void validateAmount(int amount) {
        if (amount > (javaQuestionService.repositorySize() + mathQuestionService.repositorySize())) {
            throw new QuestionsMoreThanExistedException("Запрошено больше вопросов, чем есть в списках");
        }
    }

    private int generateRandomNumber(int maxValue) {
        return random.nextInt(maxValue);
    }

    public int quantityForJava(int amount) {
        int quantityForJava;
        int quantityForMath;
        do {
            quantityForJava = generateRandomNumber(amount);
            quantityForMath = amount - quantityForJava;
        }
        while (quantityForJava > javaQuestionService.repositorySize() || quantityForMath > mathQuestionService.repositorySize());
        return quantityForJava;
    }
}
