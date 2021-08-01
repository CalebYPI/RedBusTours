package za.ac.cput.groupx30.service;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.factory.DriverRouteFactory;
import za.ac.cput.groupx30.service.driverRoute.DriverRouteService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;


class DriverRouteServiceImpTest {

    private static DriverRouteService service;
    private static DriverRoute driverRoute = DriverRouteFactory.createRoute("R21");
    //Set<DriverRoute> driverRouteSet = service.getAll();

    @Test
    void a_create() {
        DriverRoute create = service.create(driverRoute);
        assertEquals(driverRoute.getRouteID(), create.getRouteID());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        DriverRoute read = service.read(driverRoute.getRouteID());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        DriverRoute update = new DriverRoute.Builder().copy(driverRoute).setRouteID("AS12").build();
        update = service.update(update);
        System.out.println("Updated: ");
    }

    @Test
    void d_delete() {
        boolean delete = service.delete(driverRoute.getRouteID());
        assertTrue(delete);
    }

    @Test
    void e_getAll() {
        assertEquals(1, service.getAll());
        System.out.println("Get all routes: " + "\n" + service.getAll() + "\n");
    }
}