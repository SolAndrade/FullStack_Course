package main.java.com.example.studentcatalogservice.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GradesDataServiceClient {
    @Autowired
    private RestTemplate restTemplate;

    public List<Grade> getGradesByCourseCode(String courseCode) {
        String url = "http://grades-data-service/grades?courseCode=" + courseCode;
        ResponseEntity<List<Grade>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Grade>>() {}
        );
        return response.getBody();
    }

    public Course getCourseByCode(String courseCode) {
        String url = "http://grades-data-service/courses/" + courseCode;
        return restTemplate.getForObject(url, Course.class);
    }
}

