package za.ac.cput.groupx30.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.factory.RouteTicketFactory;
import za.ac.cput.groupx30.repository.routeTicket.imp.RouteTicketImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class RouteTicketImplTest {
    private static RouteTicketImpl repository = RouteTicketImpl.getRepository();
    private static RouteTicket routeTicket = RouteTicketFactory.createTicker("N1");
    private static RouteTicket routeTicket2 = RouteTicketFactory.createTicker("M5");

    @Test
    void a_create() {
        RouteTicket createRouteTicket = repository.create(routeTicket);
        RouteTicket createRoutTicket2 = repository.create(routeTicket2);
        assertEquals(createRouteTicket.getRoute(), routeTicket.getRoute());
        assertEquals(createRoutTicket2.getRoute(), routeTicket2.getRoute());
        System.out.println("Create: " + createRouteTicket + "\nCreate: " + createRoutTicket2);
    }

    @Test
    void b_read() {
        RouteTicket read = repository.read(routeTicket.getRoute());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        RouteTicket updatedRouteTicket = new RouteTicket.Builder().copy(routeTicket).setRoute("Century City").setRouteDesc("No Stop").build();
        assertNotNull(repository.update(updatedRouteTicket));
        System.out.println("Updated: " + updatedRouteTicket);
    }

    @Test
    void e_delete() {
        boolean deletedRouteTicket = repository.delete(routeTicket.getRoute());
        assertTrue(deletedRouteTicket);
        System.out.println("Delete: " + deletedRouteTicket);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}