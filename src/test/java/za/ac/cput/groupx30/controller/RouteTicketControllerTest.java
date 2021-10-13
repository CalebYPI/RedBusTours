package za.ac.cput.groupx30.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.factory.DriverRouteFactory;
import za.ac.cput.groupx30.factory.RouteTicketFactory;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */
class RouteTicketControllerTest {

    private static RouteTicket routTicket = RouteTicketFactory.createTicket("90324m", "Nmasd");
    public static String SECURITY_USERNAME = "abc";
    public static String SECURITY_PASSWORD = "";


    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/routeTicket";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<RouteTicket> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, routTicket, RouteTicket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        routTicket = postResponse.getBody();
        System.out.println("Saved data" + postResponse.getBody());
        assertEquals(routTicket.getRoute(), postResponse.getBody().getTicketID());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + routTicket.getTicketID();
        System.out.println("URL: " + url);
        ResponseEntity<RouteTicket> getResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, RouteTicket.class);
        assertEquals(routTicket.getTicketID(), getResponse.getBody().getTicketID());
    }

    @Test
    void c_update() {
        RouteTicket updated = new RouteTicket.Builder().copy(routTicket).setRoute("CTICC").setTicketID("Foreshore").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        restTemplate.put(url, updated, RouteTicket.class);
        ResponseEntity<RouteTicket> putResponse = restTemplate.getForEntity(url, RouteTicket.class);
        assertNotNull(putResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + routTicket.getTicketID();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> getResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: " + getResponse.getBody());
        assertNotNull(getResponse.getBody());
    }
}