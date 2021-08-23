//package za.ac.cput.groupx30.repository;
///*
// LocationRouteRepositoryImplTest.java
// Test Repository Implementation for the LocationRoute
// Author: Caleb Ruiters (215169751)
// Date: 20 June 2021
//*/
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.groupx30.entity.LocationRoute;
//import za.ac.cput.groupx30.factory.LocationRouteFactory;
//import za.ac.cput.groupx30.repository.route.LocationRouteRepository;
//import za.ac.cput.groupx30.repository.route.impl.LocationRouteRepositoryImpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class LocationRouteRepositoryImplTest {
//    private LocationRouteRepository repository = LocationRouteRepositoryImpl.getRepository();
//    private static LocationRoute locationRoute = LocationRouteFactory.createLocationRoute("2d3b5c02-4ded-485b-83f6-0364c820eee3","f0677076-af1d-42e2-8f8f-06f150930dd7");
//
//    @Test
//    void a_create() {
//        LocationRoute created = repository.create(locationRoute);
//        assertEquals(created.getLocationId(), locationRoute.getLocationId());
//        assertEquals(created.getRouteId(), locationRoute.getRouteId());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    void b_read() {
//        LocationRoute read = repository.read(locationRoute.getRouteId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_update() {
//        LocationRoute updated = repository.update(locationRoute);
//        assertEquals(updated.getRouteId(), locationRoute.getRouteId());
//        assertEquals(updated.getLocationId(), locationRoute.getLocationId());
//    }
//
//    @Test
//    void e_delete() {
//        boolean deleted = repository.delete(locationRoute.getRouteId());
//        assertTrue(deleted);
//        System.out.println("Deleted: " + deleted);
//    }
//
//    @Test
//    void d_getAll() {
//        assertEquals(repository.getAll().size(), 1);
//    }
//}