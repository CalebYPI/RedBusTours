package za.ac.cput.groupx30.controller.route;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationFactory;
import za.ac.cput.groupx30.factory.LocationRouteFactory;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LocationRouteControllerTest {

    private static Route route = RouteFactory.createRoute("Blue Route", 20, 60);
    private static Location location = LocationFactory.createLocation("CTICC", "Foreshore" , false);
    private static LocationRoute locationRoute = LocationRouteFactory.createLocationRoute(location.getId(),route.getId());

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/locationRoute";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<LocationRoute> postResponse = restTemplate.postForEntity(url, locationRoute, LocationRoute.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        locationRoute = postResponse.getBody();
        System.out.println("Saved data" + postResponse.getBody());
        assertEquals(locationRoute.getRouteId(), postResponse.getBody().getRouteId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/"+ locationRoute.getRouteId() + "/" + locationRoute.getLocationId();
        System.out.println("URL: " + url);
        ResponseEntity<LocationRoute> getResponse = restTemplate.getForEntity(url, LocationRoute.class);
        assertEquals(locationRoute, getResponse.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + locationRoute.getLocationId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> postResponse = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: " + postResponse.getBody());
    }
}