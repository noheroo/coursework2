package pro.sky.java.course2.coursework2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.coursework2.data.Question;
import pro.sky.java.course2.coursework2.interfaces.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        Question questionObj = new Question(question, answer);
        return questionService.add(questionObj);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        Question questionObj = new Question(question, answer);
        return questionService.remove(questionObj);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return questionService.getAll();
    }

}
