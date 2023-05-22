package com.ironhack.demo.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="student_name")
    private String studentName;

    @Column(name="section_id")
    private String sectionId;

    private Integer score;

    // constructor, getters, and setters omitted for brevity
}
