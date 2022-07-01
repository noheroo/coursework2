package pro.sky.java.course2.coursework2.interfaces;

import pro.sky.java.course2.coursework2.data.Question;

import java.util.Collection;

public interface QuestionRepository {

    void init();

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getQuestion(int numberOfQuestion);

    int questionListSize();

}
