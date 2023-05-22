package com.ironhack.demo.repository;

import com.ironhack.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

  @Query(value="SELECT student_name, CAST(AVG(score) AS double) FROM grade GROUP BY student_name HAVING AVG(score) < :score  ORDER BY student_name DESC", nativeQuery=true)
  List<Object[]> findAverageScoreBySectionWithCapacityNative(@Param("score") double score);

}
