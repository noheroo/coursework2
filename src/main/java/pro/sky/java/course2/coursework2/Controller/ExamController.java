package pro.sky.java.course2.coursework2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.coursework2.Data.Question;
import pro.sky.java.course2.coursework2.Implementation.ExaminerServiceImpl;
import pro.sky.java.course2.coursework2.Interface.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get")
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestion(amount);
    }
}
