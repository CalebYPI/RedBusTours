package za.ac.cput.groupx30.controller.route;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.RouteFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RouteControllerTest {

    private static Route route = RouteFactory.createRoute("Blue Route", 20, 60);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/route";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Route> postResponse = restTemplate.postForEntity(url, route, Route.class);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/";
        ResponseEntity<Route> postResponse = restTemplate.getForEntity(url, Route.class);
    }

    @Test
    void c_update() {
        Route updated = new Route.Builder().copy(route).setDescription("").setDistance(0).setTime(0).build();
        String url = BASE_URL + "/update";
        restTemplate.put(url, updated, Route.class);
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/";
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> postResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}