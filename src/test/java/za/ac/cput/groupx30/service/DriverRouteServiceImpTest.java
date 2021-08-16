package za.ac.cput.groupx30.service;

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.factory.DriverRouteFactory;
import za.ac.cput.groupx30.service.driverRoute.DriverRouteService;
import za.ac.cput.groupx30.service.driverRoute.impl.DriverRouteServiceImp;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */



class DriverRouteServiceImpTest {

    private DriverRouteService service = DriverRouteServiceImp.getService();
    private static DriverRoute driverRoute = DriverRouteFactory.createRoute("R21");

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