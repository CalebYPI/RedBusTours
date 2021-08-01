package za.ac.cput.groupx30.service.driverRoute.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverRouteServiceImpl Test
// Date: 02 August 2021

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.factory.DriverRouteFactory;
import za.ac.cput.groupx30.service.driverRoute.DriverRouteService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DriverRouteServiceImplTest {

    private static DriverRouteService service = DriverRouteServiceImpl.getService();
    private static DriverRoute driverRoute = DriverRouteFactory.createRoute("SOUTHERN SUBURBS-7468");

    @Test
    void getAll() {
        Set<DriverRoute> driverRoute = service.getAll();
        assertEquals(1, driverRoute.size());
        System.out.println("All driver routes: " + driverRoute);
    }

    @Test
    void create() {
        DriverRoute created;
        created = service.create(driverRoute);
        assertEquals(driverRoute.getRouteID(), created.getRouteID());
        assertEquals(driverRoute.getDriverID(), created.getDriverID());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        DriverRoute read = service.read(driverRoute.getRouteID());
        System.out.println("Read:" + read);
    }

    @Test
    void update() {
        DriverRoute.Builder builder = new DriverRoute.Builder();
        builder.copy(driverRoute);
        builder.setRouteID("SOUTHERN SUBURBS-7468");
        builder.setDriverID("3875");
        DriverRoute update = builder.build();
        System.out.println("Updated: " + update);
    }

    @Test
    void delete() {
        boolean deleted = service.delete(driverRoute.getRouteID());
        assertTrue(deleted);
    }
}