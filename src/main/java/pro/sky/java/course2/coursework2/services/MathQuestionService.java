package pro.sky.java.course2.coursework2.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.exception.TryingToGetAccessToWrongRepository;
import pro.sky.java.course2.coursework2.interfaces.QuestionRepository;
import pro.sky.java.course2.coursework2.interfaces.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final Random random = new Random();

    private final QuestionRepository questionRepository;

    public MathQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question add(Question question) {
        throw new TryingToGetAccessToWrongRepository("Попытка доступа к неверному репозиторию");
    }

    @Override
    public Question remove(Question question) {
        throw new TryingToGetAccessToWrongRepository("Попытка доступа к неверному репозиторию");

    }

    @Override
    public Collection<Question> getAll() {
        throw new TryingToGetAccessToWrongRepository("Попытка доступа к неверному репозиторию");
    }

    @Override
    public Question getRandomQuestion() {
            return createRandomQuestion();
    }

    @Override
    public int repositorySize() {
            return generateRandomNumber(10);
    }

    private int generateRandomNumber(int maxValue) {
        return random.nextInt(maxValue);
    }

    private Question createRandomQuestion() {
        return new Question(generateStringFromLetters(15), generateStringFromLetters(10));
    }

    private String generateStringFromLetters(int length) {
        return random.ints(97, 123)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
