package za.ac.cput.groupx30.repository.driverRoute.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Entity: DriverRouteRepositoryImpl Test
// Date: 26 July 2021

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.factory.DriverRouteFactory;
import za.ac.cput.groupx30.repository.driverRoute.DriverRouteRepository;

import static org.junit.jupiter.api.Assertions.*;

class DriverRouteRepositoryImplTest {

    private static DriverRouteRepository repository = DriverRouteRepositoryImpl.getRepository();
    private static DriverRoute driverRoute = DriverRouteFactory.createRoute("NORTHERN SUBURBS-5468", "");

    @Test
    public void a_create(){
        DriverRoute created = repository.create(driverRoute);
        assertEquals(driverRoute.getRouteID(), created.getRouteID());
        assertEquals(driverRoute.getDriverID(), created.getDriverID());
        System.out.println("Created DriverRoute: " + created);
    }

    @Test
    public void b_read(){
        DriverRoute read = repository.read(driverRoute.getRouteID());
        System.out.println("Read: " + read);
    }

//    @Test
//    public void c_update(){
//        DriverRoute updated = new DriverRoute.Builder().copy(driverRoute).setId("Mercedes Benz - Bus15 2020 Model").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }

    @Test
    public void e_delete(){
        boolean deleted = repository.delete(driverRoute.getRouteID());
        assertTrue(deleted);
        System.out.println("Successfully deleted!");
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }
}