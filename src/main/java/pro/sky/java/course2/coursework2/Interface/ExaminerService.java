package pro.sky.java.course2.coursework2.Interface;

import pro.sky.java.course2.coursework2.Data.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);
}
