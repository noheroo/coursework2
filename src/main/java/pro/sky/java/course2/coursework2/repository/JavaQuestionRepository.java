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
public class JavaQuestionRepository implements QuestionRepository {

    private final List<Question> questionList;

    public JavaQuestionRepository() {
        this.questionList = new ArrayList<>();
    }

    @Override
    @PostConstruct
    public void init() {
        questionList.addAll(List.of(
                createQuestion("JavaQuestion1", "JavaAnswer1"),
                createQuestion("JavaQuestion2", "JavaAnswer2"),
                createQuestion("JavaQuestion3", "JavaAnswer3"),
                createQuestion("JavaQuestion4", "JavaAnswer4"),
                createQuestion("JavaQuestion5", "JavaAnswer5"),
                createQuestion("JavaQuestion6", "JavaAnswer6"),
                createQuestion("JavaQuestion7", "JavaAnswer7"),
                createQuestion("JavaQuestion8", "JavaAnswer8"),
                createQuestion("JavaQuestion9", "JavaAnswer9"),
                createQuestion("JavaQuestion10", "JavaAnswer10")
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
