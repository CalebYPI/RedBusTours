package za.ac.cput.groupx30.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LocationControllerTest {

    private static Location location = LocationFactory.createLocation("CTICC", "Foreshore" , false);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/route";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Location> postResponse = restTemplate.postForEntity(url, location, Location.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        location = postResponse.getBody();
        System.out.println("Saved data" + postResponse.getBody());
        assertEquals(location.getId(), postResponse.getBody().getId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + location.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Location> getResponse = restTemplate.getForEntity(url, Location.class);
        assertEquals(location.getId(), getResponse.getBody().getId());
    }

    @Test
    void c_update() {
        Location updated = new Location.Builder().copy(location).setDescription("CTICC").setArea("Foreshore").setPickupPoint(true).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        restTemplate.put(url, updated, Location.class);
        ResponseEntity<Location> putResponse = restTemplate.getForEntity(url, Location.class);
        assertNotNull(putResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + location.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> getResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: " + getResponse.getBody());
        assertNotNull(getResponse.getBody());
    }
}