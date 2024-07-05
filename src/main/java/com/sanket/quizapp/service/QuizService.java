package com.sanket.quizapp.service;

import com.sanket.quizapp.dao.QuestionDAO;
import com.sanket.quizapp.dao.QuizDAO;
import com.sanket.quizapp.model.Question;
import com.sanket.quizapp.model.QuestionWrapper;
import com.sanket.quizapp.model.Quiz;
import com.sanket.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<String> getQuestionsByCategory(String category, int numQ, String title) {
        List<Question> questions=questionDAO.getQueByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDAO.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(int id) {
        Optional<Quiz> quiz=quizDAO.findById(id);
        List<Question> questions=quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser=new ArrayList<>();
        for(Question q:questions ){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(int id, List<Response> responses) {
        Quiz quiz=quizDAO.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }

        return new ResponseEntity<>(right,HttpStatus.OK);
    }

    public ResponseEntity<List<Quiz>> getAll() {
        return new ResponseEntity<>(quizDAO.findAll(),HttpStatus.OK);
    }
}
