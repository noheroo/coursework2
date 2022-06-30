package pro.sky.java.course2.coursework2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.exception.QuestionAlreadyAddedException;
import pro.sky.java.course2.coursework2.exception.QuestionNotFoundException;
import pro.sky.java.course2.coursework2.interfaces.QuestionRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final List<Question> questionList;

    public MathQuestionRepository() {
        this.questionList = new ArrayList<>();
    }

    @Override
    @PostConstruct
    public void init() {
        questionList.addAll(List.of(
                createQuestion("MathQuestion1", "MathAnswer1"),
                createQuestion("MathQuestion2", "MathAnswer2"),
                createQuestion("MathQuestion3", "MathAnswer3"),
                createQuestion("MathQuestion4", "MathAnswer4"),
                createQuestion("MathQuestion5", "MathAnswer5")
        ));
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
        return Collections.unmodifiableList(questionList);
    }

    @Override
    public Question getQuestion(int numberOfQuestion) {
        return questionList.get(numberOfQuestion);
    }

    @Override
    public int questionListSize() {
        return questionList.size();
    }

    private Question createQuestion (String question, String answer) {
        return new Question(question, answer);
    }
    private void validateQuestionForAdd(Question question) {
        if (questionList.contains(question)) {
            throw new QuestionAlreadyAddedException("Такой вопрос уже есть");
        }
    }

    private void validateQuestionForRemove(Question question) {
        if (!questionList.contains(question)) {
            throw new QuestionNotFoundException("Такой вопрос отсутствует");
        }
    }
}
