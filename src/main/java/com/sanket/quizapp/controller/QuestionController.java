package com.sanket.quizapp.controller;

import com.sanket.quizapp.model.Question;
import com.sanket.quizapp.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("question")
public class QuestionController {

    @Autowired
    questionService questionservice;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionservice.getAllQuestions();
    }

    @GetMapping("category/{text}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String text){
        return questionservice.getByCategory(text);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionservice.addQuestion(question);
    }

    @DeleteMapping("delete/{text}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String text){
        return questionservice.deleteQuestion(text);
    }

    @PutMapping("update/{text}")
    public ResponseEntity<String> updateQuestion(@PathVariable("text") String id,@RequestBody Question q){
        return questionservice.updateQuestion(id,q);
    }
}
