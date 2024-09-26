package pro.sky.java.course2.coursework2.Implementation;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.Data.Question;
import pro.sky.java.course2.coursework2.Exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.coursework2.Exception.QuestionNotFoundException;
import pro.sky.java.course2.coursework2.Interface.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final ArrayList<Question> questionList;

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
    public Question remove(String question, String answer) {
        Question questionObj = createQuestion(question, answer);
        validateQuestionForRemove(questionObj);
        questionList.remove(questionObj);
        return questionObj;
    }

    @Override
    public Collection<Question> getAll() {
        return questionList;
    }

    @Override
    public Question getRandomQuestion() {
        return questionList.get(generateRandomNumber(questionList.size() - 1));
    }

    @Override
    public int questionListSize() {
        return questionList.size();
    }

    private static int generateRandomNumber(int maxValue) {
        Random random = new Random();
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
