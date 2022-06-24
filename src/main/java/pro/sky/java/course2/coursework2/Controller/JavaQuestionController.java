package pro.sky.java.course2.coursework2.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.coursework2.Data.Question;
import pro.sky.java.course2.coursework2.Implementation.JavaQuestionService;
import pro.sky.java.course2.coursework2.Interface.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        return questionService.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getAQuestions() {
        return questionService.getAll();
    }

}
