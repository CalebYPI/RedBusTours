package za.ac.cput.groupx30.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
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
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        route = postResponse.getBody();
        System.out.println("Saved data" + postResponse.getBody());
        assertEquals(route.getId(), postResponse.getBody().getId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + route.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Route> getResponse = restTemplate.getForEntity(url, Route.class);
        assertEquals(route.getId(), getResponse.getBody().getId());
    }

    @Test
    void c_update() {
        Route updated = new Route.Builder().copy(route).setDescription("Blue Trail").setDistance(32).setTime(67).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + updated);
        restTemplate.put(url, updated, Route.class);
        ResponseEntity<Route> putResponse = restTemplate.getForEntity(url, Route.class);
        assertNotNull(putResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + route.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> getResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("All Data: " + getResponse.getBody());
        assertNotNull(getResponse);
    }
}