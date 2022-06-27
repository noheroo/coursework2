package pro.sky.java.course2.coursework2.implementation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.coursework2.exception.QuestionNotFoundException;
import pro.sky.java.course2.coursework2.interfaces.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
@Service
public class JavaQuestionService implements QuestionService {

    Random random = new Random();

    private final List<Question> questionList;

    public JavaQuestionService() {
        this.questionList = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question questionObj = createQuestion(question, answer);
        validateQuestionForAdd(questionObj);
        questionList.add(questionObj);
        return questionObj;
    }

    @Override
    public Question add(Question question) {
        validateQuestionForAdd(question);
        questionList.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        validateQuestionForRemove(question);
        questionList.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionList;
    }

    @Override
    public Question getRandomQuestion() {
        return questionList.get(generateRandomNumber(questionList.size() - 1));
    }

    public int questionListSize() {
        return questionList.size();
    }

    private int generateRandomNumber(int maxValue) {
        return random.nextInt(maxValue);
    }

    private Question createQuestion(String question, String answer) {
        return new Question(question, answer);
    }

    private void validateQuestionForRemove(Question question) {
        if (!questionList.contains(question)) {
            throw new QuestionNotFoundException("Такой вопрос отсутствует");
        }
    }

    private void validateQuestionForAdd(Question question) {
        if (questionList.contains(question)) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже есть");
        }
    }
}
