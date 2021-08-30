package za.ac.cput.groupx30.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationFactory;
import za.ac.cput.groupx30.factory.LocationRouteFactory;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.service.impl.LocationRouteServiceImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LocationRouteServiceImplTest {
    private static LocationRouteService service = LocationRouteServiceImpl.getService();
    private static Location stop = LocationFactory.createLocation("Table Mountain", "Cape Town", true);
    private static Route red = RouteFactory.createRoute("Peninsula Route", 20, 120);
    private static LocationRoute locationRoute = LocationRouteFactory.createLocationRoute(stop.getId(), red.getId());

    @Test
    void a_create() {
        LocationRoute create = service.save(locationRoute);
        assertEquals(locationRoute.getRouteId(),create.getRouteId());
        assertEquals(locationRoute.getLocationId(),create.getLocationId());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        LocationRoute.LocationRouteId id = new LocationRoute.LocationRouteId(locationRoute.getRouteId(), locationRoute.getLocationId());
        LocationRoute read = service.read(id);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void g_delete() {
        boolean delete = service.delete(locationRoute);
        assertTrue(delete);
        System.out.println("Deleted: " + delete);
    }

    @Test
    void d_getAll() {
        assertEquals(service.getAll().size(), 1);
    }

    @Test
    @Disabled
    void e_findAllByLocationId() {
        Set<LocationRoute> locations = service.findAllByLocationId(stop.getId());
        assertNotNull(locations);
    }

    @Test
    @Disabled
    void f_findAllByRouteId() {
        Set<LocationRoute> routes = service.findAllByRouteId(red.getId());
        assertNotNull(routes);
    }
}