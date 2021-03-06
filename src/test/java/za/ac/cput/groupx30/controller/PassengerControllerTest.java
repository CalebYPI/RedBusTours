package za.ac.cput.groupx30.controller;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Test case for Passenger controller
 * Date: 15 August 2021
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.factory.PassengerFactory;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PassengerControllerTest {

    private static Passenger passenger = PassengerFactory.createPassenger("Shaheed", "0788859654");
    public static String SECURITY_USERNAME = "shaheed";
    public static String SECURITY_PASSWORD = "963852741";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/passenger";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Passenger> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, passenger, Passenger.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        passenger = postResponse.getBody();
        System.out.println("Saved data: " + passenger);
        assertEquals(passenger.getId(), postResponse.getBody().getId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + passenger.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Passenger> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Passenger.class);
    }

    @Test
    void c_update() {
        Passenger updated = new Passenger.Builder().copy(passenger).setName("David").setContact("0854625789").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Passenger> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Passenger.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete" + passenger.getId();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

    @Test
    void d_getall() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: " + response.getBody());
        assertNotNull(response.getBody());

    }
}