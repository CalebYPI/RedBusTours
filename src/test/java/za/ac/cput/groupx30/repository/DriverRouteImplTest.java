package za.ac.cput.groupx30.repository;
/**
 * Baron Mukenyi (217163742)
 * Test class repository for Driver Route
 * 25 July 2021
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.factory.DriverRouteFactory;
import za.ac.cput.groupx30.repository.driverRoute.impl.DriverRouteImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class DriverRouteImplTest {
    private static DriverRouteImpl repository = DriverRouteImpl.getRepository();
    private static DriverRoute driverRoute = DriverRouteFactory.createRoute("745734", "");
    private static DriverRoute driverRoute2 = DriverRouteFactory.createRoute("261", "");

    @Test
    void a_create() {
        DriverRoute created = repository.create(driverRoute);
        DriverRoute created2 = repository.create(driverRoute2);
        assertEquals(created.getRouteID(), driverRoute.getRouteID());
        assertEquals(created2.getRouteID(), driverRoute2.getRouteID());

        System.out.println("Created: " + created + "\nCreate: " + created2);
    }

    @Test
    void b_read() {
        DriverRoute read = repository.read(driverRoute.getRouteID());
        assertNotNull(read);

        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        DriverRoute updatedRoute = new DriverRoute.Builder().copy(driverRoute).setDriverID("1234").setRouteID("9102").build();
        assertNotNull(repository.update(updatedRoute));
        System.out.println("Update: " + updatedRoute);
    }

    @Test
    void e_delete() {
        boolean deleted = repository.delete(driverRoute.getRouteID());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}