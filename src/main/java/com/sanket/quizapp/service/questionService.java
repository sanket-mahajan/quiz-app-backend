package com.sanket.quizapp.service;

import com.sanket.quizapp.model.Question;
import com.sanket.quizapp.dao.QuestionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class questionService {
    @Autowired
    QuestionDAO questiondao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getByCategory(String text) {
        try {
            return new ResponseEntity<>( questiondao.findByCategory(text),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( questiondao.findByCategory(text),HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questiondao.save(question);
            return new ResponseEntity<>( "added",HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( "cant add",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> deleteQuestion(String text) {
        int id=Integer.parseInt(text);
        try{
            questiondao.deleteById(id);
            return new ResponseEntity<>( "deleted",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( "cant delete",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> updateQuestion(String id,Question q) {
        try {
            int i = Integer.parseInt(id);
            Question copy = questiondao.getReferenceById(i);
            if (questiondao.existsById(i)) {
                q.setId(i);
                if (q.getQuestionTitle() != null) {
                    copy.setQuestionTitle(q.getQuestionTitle());
                }
                if (q.getOption1() != null) {
                    copy.setOption1(q.getOption1());
                }
                if (q.getOption2() != null) {
                    copy.setOption2(q.getOption2());
                }
                if (q.getOption3() != null) {
                    copy.setOption3(q.getOption3());
                }
                if (q.getOption4() != null) {
                    copy.setOption4(q.getOption4());
                }
                if (q.getRightAnswer() != null) {
                    copy.setRightAnswer(q.getRightAnswer());
                }
                if (q.getDifficultyLevel() != null) {
                    copy.setDifficultyLevel(q.getDifficultyLevel());
                }
                if (q.getCategory() != null) {
                    copy.setCategory(q.getCategory());
                }
                questiondao.save(copy);
            }
            return new ResponseEntity<>("updated",HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( "cant update",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
