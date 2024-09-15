package pro.sky.java.course2.coursework2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.interfaces.QuestionRepository;
import pro.sky.java.course2.coursework2.interfaces.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();

    private final QuestionRepository questionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return questionRepository.getQuestion(generateRandomNumber(repositorySize()));
    }

    @Override
    public int repositorySize() {
        return questionRepository.questionListSize();
    }

    private int generateRandomNumber(int maxValue) {
        return random.nextInt(maxValue);
    }

}
