package com.sanket.quizapp.dao;

import com.sanket.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDAO extends JpaRepository <Quiz,Integer> {

}
