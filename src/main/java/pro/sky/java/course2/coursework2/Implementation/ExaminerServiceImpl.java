package pro.sky.java.course2.coursework2.Implementation;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework2.Data.Question;
import pro.sky.java.course2.coursework2.Exception.AmountQuestionsMoreThanExistedException;
import pro.sky.java.course2.coursework2.Interface.ExaminerService;
import pro.sky.java.course2.coursework2.Interface.QuestionService;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final ArrayList<Question> listForExam;

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.listForExam = new ArrayList<>();
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        validateAmount(amount);
        while (listForExam.size() != amount) {
            Question questionObj = questionService.getRandomQuestion();
            if (!listForExam.contains(questionObj)) {
                listForExam.add(questionObj);
            }
        }
        return listForExam;
        //todo при первом запуске запроса листа допустим http://localhost:8080/exam/get?amount=5 все отрабатывается нормально, но если следом запустить еще один подобный запрос типа http://localhost:8080/exam/get?amount=3 запрос зависает, почему не разобрался((
    }


    private void validateAmount(int amount) {
        if (amount > questionService.questionListSize()) {
            throw new AmountQuestionsMoreThanExistedException("Запрошено больше вопросов, чем есть");
        }
    }
}
