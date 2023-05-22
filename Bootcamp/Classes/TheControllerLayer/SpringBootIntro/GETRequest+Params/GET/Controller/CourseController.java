package TheControllerLayer.SpringBootIntro.GETRequest+Params.GET.Controller;

package com.ironhack.demo.controller;

import com.ironhack.demo.model.Courses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CourseController implements CourseControllerInterface {

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCourses() {

      //this would typically be a call to your data or service layer
      List<Course> courseList = new ArrayList<>();

      courseList.add(new Course("MA101", "College Algebra"));
      courseList.add(new Course("MA102", "Calculus 1"));

      return courseList;
    }

}
