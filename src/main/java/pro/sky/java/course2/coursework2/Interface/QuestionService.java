package pro.sky.java.course2.coursework2.Interface;

import pro.sky.java.course2.coursework2.Data.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int questionListSize();
}
