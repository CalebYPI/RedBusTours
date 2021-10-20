package za.ac.cput.groupx30.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.factory.GuideFactory;

public class GuideControllerTest {
    private static Guide guide = GuideFactory.createId("Seapoint");
    public static String SECURITY_USERNAME = "admin";
    public static String SECURITY_PASSWORD = "root";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/guide";

    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Guide> postResponse = restTemplate.postForEntity(url, guide, Guide.class);
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/";
        ResponseEntity<Guide> postResponse = restTemplate.getForEntity(url, Guide.class);
    }

    @Test
    void update() {
        Guide updated = new Guide.Builder().copy(guide).setId("").setName("").build();
        String url = BASE_URL + "/update";
        restTemplate.put(url, updated, Guide.class);
    }

    @Test
    void delete() {
        String url = BASE_URL + "/delete/";
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

    }
}
