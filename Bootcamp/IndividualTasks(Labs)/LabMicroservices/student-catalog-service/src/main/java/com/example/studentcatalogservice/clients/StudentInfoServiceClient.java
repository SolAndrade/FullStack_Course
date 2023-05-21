package main.java.com.example.studentcatalogservice.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StudentInfoServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    public Student getStudentById(String studentId) {
        String url = "http://student-info-service/students/" + studentId;
        return restTemplate.getForObject(url, Student.class);
    }
}

