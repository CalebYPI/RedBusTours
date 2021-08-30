package za.ac.cput.groupx30.controller.DriverRoute;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.factory.DriverRouteFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */

class DriverRouteControllerTest {

    private static DriverRoute driverRoute = DriverRouteFactory.createRoute("90324m", "Nmasd");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/driverRoute";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<DriverRoute> postResponse = restTemplate.postForEntity(url, driverRoute, DriverRoute.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        driverRoute = postResponse.getBody();
        System.out.println("Saved data" + postResponse.getBody());
        assertEquals(driverRoute.getDriverID(), postResponse.getBody().getRouteID());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + driverRoute.getDriverID();
        System.out.println("URL: " + url);
        ResponseEntity<DriverRoute> getResponse = restTemplate.getForEntity(url, DriverRoute.class);
        assertEquals(driverRoute.getDriverID(), getResponse.getBody().getRouteID());
    }

    @Test
    void c_update() {
        DriverRoute updated = new DriverRoute.Builder().copy(driverRoute).setDriverID("CTICC").setRouteID("Foreshore").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        restTemplate.put(url, updated, DriverRoute.class);
        ResponseEntity<DriverRoute> putResponse = restTemplate.getForEntity(url, DriverRoute.class);
        assertNotNull(putResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + driverRoute.getDriverID();
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