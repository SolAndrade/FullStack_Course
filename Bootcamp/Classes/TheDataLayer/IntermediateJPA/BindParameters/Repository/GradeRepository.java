package com.ironhack.demo.repository;

import com.ironhack.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

  @Query("SELECT sectionId, AVG(score) FROM Grade GROUP BY sectionId HAVING COUNT(*) >= ?1 ORDER BY AVG(score)")
  List<Object[]> findAverageScoreBySectionWithCapacity(Long minEnrolled);

  @Query("SELECT sectionId, AVG(score) FROM Grade GROUP BY sectionId HAVING COUNT(*) >= :minEnrolled ORDER BY AVG(score)")
  List<Object[]> findAverageScoreBySectionWithCapacity2(@Param("minEnrolled") long minEnrolled);

}
