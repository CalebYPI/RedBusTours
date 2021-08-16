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
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.factory.LocationRouteFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LocationRouteControllerTest {

    private static LocationRoute locationRoute = LocationRouteFactory.createLocationRoute("","");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/locationRoute";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<LocationRoute> postResponse = restTemplate.postForEntity(url, locationRoute, LocationRoute.class);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/create";
        ResponseEntity<LocationRoute> postResponse = restTemplate.getForEntity(url, LocationRoute.class);
    }

    @Test
    void c_update() {
        String url = BASE_URL + "/create";
        restTemplate.put(url, locationRoute, LocationRoute.class);
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/create";
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/create";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> postResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }
}