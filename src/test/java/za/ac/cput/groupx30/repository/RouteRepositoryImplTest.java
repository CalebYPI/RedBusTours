package za.ac.cput.groupx30.repository;
/*
 RouteRepositoryImplTest.java
 Test Repository Implementation for the Route
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/
import org.junit.jupiter.api.*;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.repository.route.RouteRepository;
import za.ac.cput.groupx30.repository.route.impl.RouteRepositoryImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class RouteRepositoryImplTest {

    private RouteRepository repository = RouteRepositoryImpl.getRepository();
    private static Route route = RouteFactory.createRoute("Wine Route", 25, 72);

    @Test
    void a_create() {
        Route created = repository.create(route);
        assertEquals(created.getId(), route.getId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Route read = repository.read(route.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Route updated = new Route.Builder().copy(route).setDescription("Blue Route").build();
        updated = repository.update(updated);
        assertEquals(updated.getId(), route.getId());
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean deleted = repository.delete(route.getId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void d_getAll() {
        Set<Route> routes = repository.getAll();
        assertEquals(1, routes.size());
        System.out.println("All Routes: " + routes);
    }
}