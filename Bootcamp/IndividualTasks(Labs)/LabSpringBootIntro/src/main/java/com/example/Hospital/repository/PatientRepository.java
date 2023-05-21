package com.example.Hospital.repository;

import com.example.Hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAll();
    List<Patient> findByDateOfBirthBetween(Date startDate, Date endDate);
    List<Patient> findByAdmittedByDepartment(String department);
    List<Patient> findByAdmittedByStatus(String status);
    Patient save(Patient patient);
}
