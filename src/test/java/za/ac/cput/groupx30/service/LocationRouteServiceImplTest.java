package za.ac.cput.groupx30.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationFactory;
import za.ac.cput.groupx30.factory.LocationRouteFactory;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.service.route.LocationRouteService;
import za.ac.cput.groupx30.service.route.impl.LocationRouteServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LocationRouteServiceImplTest {
    private static LocationRouteService service = LocationRouteServiceImpl.getService();
    private static Location stop = LocationFactory.createLocation("Table Mountain", "Cape Town", true);
    private static Route red = RouteFactory.createRoute("Peninsula Route", 20, 120);
    private static LocationRoute locationRoute = LocationRouteFactory.createLocationRoute(stop.getId(), red.getId());

    @Test
    void a_create() {
        LocationRoute create = service.create(locationRoute);
        assertEquals(locationRoute.getRouteId(),create.getRouteId());
        assertEquals(locationRoute.getLocationId(),create.getLocationId());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        LocationRoute read = service.read(stop.getId(), red.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_delete() {
        boolean delete = service.delete(stop.getId(), red.getId());
        assertTrue(delete);
        System.out.println("Deleted: " + delete);
    }
}