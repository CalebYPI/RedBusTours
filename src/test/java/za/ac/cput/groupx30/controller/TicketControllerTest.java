package za.ac.cput.groupx30.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.factory.TicketFactory;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 27 August 2021
 */

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TicketControllerTest {

    private static Ticket ticket = TicketFactory.createTicket("27/8/2021", "15:54", 150);
    public static String SECURITY_USERNAME = "abc";
    public static String SECURITY_PASSWORD = "";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/ticket";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Ticket> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, ticket, Ticket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        ticket = postResponse.getBody();
        System.out.println("Saved data" + postResponse.getBody());
        assertEquals(ticket.getId(), postResponse.getBody().getId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + ticket.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Ticket> getResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Ticket.class);
        assertEquals(ticket.getId(), getResponse.getBody().getId());
    }

    @Test
    void c_update() {
        Ticket updated = new Ticket.Builder().copy(ticket).setTime("CTICC").setDate("Foreshore").setPrice(0).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        restTemplate.put(url, updated, Ticket.class);
        ResponseEntity<Ticket> putResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Ticket.class);
        assertNotNull(putResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + ticket.getId();
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