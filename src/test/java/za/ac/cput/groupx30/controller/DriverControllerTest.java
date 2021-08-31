package za.ac.cput.groupx30.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.DriverFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DriverControllerTest {

    private static Driver driver = DriverFactory.createId("Sam");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/driver";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Driver> postResponse = restTemplate.postForEntity(url, driver, Driver.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        driver = postResponse.getBody();
        System.out.println("Saved data" + postResponse.getBody());
        assertEquals(driver.getId(), postResponse.getBody().getId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + driver.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Driver> getResponse = restTemplate.getForEntity(url, Driver.class);
        assertEquals(driver.getId(), getResponse.getBody().getId());
    }

    @Test
    void c_update() {
        Driver updated = new Driver.Builder().copy(driver).setName("Samuel").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated Data: " + updated);
        restTemplate.put(url, updated, Driver.class);
        ResponseEntity<Driver> putResponse = restTemplate.getForEntity(url, Driver.class);
        assertNotNull(putResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + driver.getId();
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