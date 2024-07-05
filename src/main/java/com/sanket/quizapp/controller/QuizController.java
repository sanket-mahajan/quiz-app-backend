package com.sanket.quizapp.controller;

import com.sanket.quizapp.model.Question;
import com.sanket.quizapp.model.QuestionWrapper;
import com.sanket.quizapp.model.Quiz;
import com.sanket.quizapp.model.Response;
import com.sanket.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizservice;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizservice.getQuestionsByCategory(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
        return quizservice.getQuizById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
        return quizservice.submitQuiz(id,responses);
    }

    @GetMapping("/allQuizzes")
    public ResponseEntity<List<Quiz>> getAll(){
        return quizservice.getAll();
    }
}
