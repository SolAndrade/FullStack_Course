package com.example.IronLibrary.repository;

import com.example.IronLibrary.model.Issue;
import com.example.IronLibrary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer>{

    List<Issue> findByIssueStudent (Optional<Student> student);
}
