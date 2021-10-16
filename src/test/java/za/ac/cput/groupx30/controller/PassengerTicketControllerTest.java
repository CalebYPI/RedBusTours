package za.ac.cput.groupx30.controller;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Test case for PassengerTicket controller
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
import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.factory.PassengerFactory;
import za.ac.cput.groupx30.factory.PassengerTicketFactory;
import za.ac.cput.groupx30.factory.TicketFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PassengerTicketControllerTest {

    private static Passenger passenger = PassengerFactory.createPassenger("Shaheed", "0873587441");
    private static Ticket ticket = TicketFactory.createTicket("06/06/2021","15:00", 250);
    private static PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket(passenger.getId(), ticket.getId());

    public static String SECURITY_USERNAME = "shaheed";
    public static String SECURITY_PASSWORD = "963852741";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/passengerTicket";


    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<PassengerTicket> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, passengerTicket, PassengerTicket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        passengerTicket = postResponse.getBody();
        System.out.println("Saved data: " + passengerTicket);
        assertEquals(passengerTicket.getPassengerId(), postResponse.getBody().getPassengerId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read" + passengerTicket.getPassengerId() + "/" + passengerTicket.getTicketId();
        System.out.println("URL: " + url);
        ResponseEntity<PassengerTicket> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, PassengerTicket.class);
        assertEquals(passengerTicket, postResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete" + passengerTicket.getPassengerId();
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
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}