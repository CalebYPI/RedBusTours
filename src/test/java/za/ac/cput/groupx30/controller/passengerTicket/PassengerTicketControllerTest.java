package za.ac.cput.groupx30.controller.passengerTicket;

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
import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.factory.PassengerTicketFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PassengerTicketControllerTest {

    private static PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket("08971b55-1dc8-4ea2-8ed1-49ad34e9cb3f", "313f4165-fde0-4375-adc7-2aa760c5a1ea");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/passengerTicket";


    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<PassengerTicket> postResponse = restTemplate.postForEntity(url, passengerTicket, PassengerTicket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        passengerTicket = postResponse.getBody();
        System.out.println("Saved data: " + passengerTicket);
        assertEquals(passengerTicket.getPassengerId(), postResponse.getBody().getPassengerId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read";
        System.out.println("URL: " + url);
        ResponseEntity<PassengerTicket> postResponse = restTemplate.getForEntity(url, PassengerTicket.class);
    }

    @Test
    void c_update() {
        String url = BASE_URL + "update";
        restTemplate.put(url, passengerTicket, PassengerTicket.class);
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete";
        restTemplate.delete(url);
    }

    @Test
    void d_getall() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}