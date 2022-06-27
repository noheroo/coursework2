package pro.sky.java.course2.coursework2.interfaces;

import pro.sky.java.course2.coursework2.data.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
