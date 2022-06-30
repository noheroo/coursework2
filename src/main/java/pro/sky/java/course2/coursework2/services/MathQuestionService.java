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

    private final String typeOfQuestions = "Math";

    public MathQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question add(Question question) {
        validateRepository(typeOfQuestions);
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        validateRepository(typeOfQuestions);
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        validateRepository(typeOfQuestions);
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (!questionRepository.typeOfRepository().equalsIgnoreCase(typeOfQuestions)) {
            return createRandomQuestion();
        }
        return questionRepository.getQuestion(generateRandomNumber(repositorySize()));
    }

    @Override
    public int repositorySize() {
        if (!questionRepository.typeOfRepository().equalsIgnoreCase(typeOfQuestions)) {
            return generateRandomNumber(10);
        }
        return questionRepository.questionListSize();
    }

    private int generateRandomNumber(int maxValue) {
        return random.nextInt(maxValue);
    }

    @Override
    public void validateRepository(String typeOfQuestions) {
        if (!questionRepository.typeOfRepository().equalsIgnoreCase(typeOfQuestions)) {
            throw new TryingToGetAccessToWrongRepository("Попытка доступа к неверному репозиторию");
        }
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
