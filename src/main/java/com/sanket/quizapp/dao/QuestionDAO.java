package com.sanket.quizapp.dao;

import com.sanket.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository <Question,Integer> {
    List<Question> findByCategory(String text);

    @Query(value = "SELECT * FROM question q WHERE category = :category ORDER BY RAND() LIMIT :numQ\n",nativeQuery = true)
    List<Question> getQueByCategory(String category, int numQ);
}
