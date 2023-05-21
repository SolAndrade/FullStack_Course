package com.example.Hospital.controller;

import com.example.Hospital.model.Patient;
import com.example.Hospital.repository.PatientRepository;
import main.java.com.example.Hospital.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    public PatientRepository patientRepository;

    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{patient_id}")
    public Patient getPatientById(@PathVariable("patient_id") Long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    @GetMapping("/patient/date_of_birth")
    public List<Patient> getPatientsByDateOfBirth(@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                  @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/patient/department")
    public List<Patient> getPatientsByDepartment(@RequestParam("department") String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/patient/status")
    public List<Patient> getPatientsByDoctorStatus() {
        return patientRepository.findByAdmittedByStatus("OFF");
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientRepository.save(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @PutMapping("/patient/{patient_id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId, @RequestBody Patient patientRequest) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setName(patientRequest.getName());
            patient.setDateOfBirth(patientRequest.getDateOfBirth());
            patient.setAdmittedBy(patientRequest.getAdmittedBy());
            Patient savedPatient = patientRepository.save(patient);
            return new ResponseEntity<>(savedPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
