package za.ac.cput.groupx30.controller;

// Author: Thokozile Snono
// Student number: 216032121
// Controller: DriverVehicleControllerTest Class
// Date: 16 August 2021

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
import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.factory.DriverVehicleFactory;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DriverVehicleControllerTest {

    private static DriverVehicle driverVehicle = DriverVehicleFactory.createDriverVehicle("Bus15", "");
    public static String SECURITY_USERNAME = "abcd";
    public static String SECURITY_PASSWORD = "password";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/driverVehicle";

    @Test
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity< DriverVehicle > postResponse = restTemplate.postForEntity(url, driverVehicle, DriverVehicle.class);
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/";
        ResponseEntity< DriverVehicle > postResponse = restTemplate.getForEntity(url, DriverVehicle.class);
    }

    @Test
    void update() {
        DriverVehicle updated = new DriverVehicle.Builder().copy(driverVehicle).setVehicleId("Mercedes Benz - Bus15").build();
        String url = BASE_URL + "/update";
        restTemplate.put(url, updated, DriverVehicle.class);
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
        HttpEntity< String > entity = new HttpEntity<>(null, headers);
        ResponseEntity< String > postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
    }
}
