package main.java.com.example.gradesdataservice.repository;

import main.java.com.example.gradesdataservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
