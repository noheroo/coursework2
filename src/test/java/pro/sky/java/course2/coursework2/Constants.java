package pro.sky.java.course2.coursework2;

import pro.sky.java.course2.coursework2.Data.Question;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final String TEST_QUESTION_1= "QUESTION_1";
    public static final String TEST_QUESTION_2= "QUESTION_2";
    public static final String TEST_ANSWER_1= "ANSWER_1";
    public static final String TEST_ANSWER_2= "ANSWER_2";

    public static final Question QUESTION1 = new Question(TEST_QUESTION_1, TEST_ANSWER_1);
    public static final Question QUESTION2 = new Question(TEST_QUESTION_2, TEST_ANSWER_2);

    public static final ArrayList<Question> TEST_LIST = new ArrayList<>(List.of(QUESTION1,QUESTION2));
    public static final ArrayList<Question> TEST_LIST_1 = new ArrayList<>(List.of(QUESTION1));


    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int FIVE = 5;

    public static final boolean TRUE = true;
    public static final boolean FALSE = false;

}
