package za.ac.cput.groupx30.service;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */


import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.factory.RouteTicketFactory;
import za.ac.cput.groupx30.service.routeTicket.RouteTicketService;

import static org.junit.jupiter.api.Assertions.*;

class RouteTicketServiceImpTest {

    private static RouteTicketService service;
    private static RouteTicket routeTicket = RouteTicketFactory.createTicker("To Johannesburg");


    @Test
    void e_getService() {
    }

    @Test
    void a_create() {
        RouteTicket create = service.create(routeTicket);
        assertEquals(routeTicket.getRoute(), create.getRouteDesc());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        RouteTicket read = service.read(routeTicket.getRouteDesc());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        RouteTicket update = new RouteTicket.Builder().copy(routeTicket).setRoute("Johannesburg").setRouteDesc("Passing Durban").build();
        update = service.update(update);
        System.out.println("Update: " );
    }

    @Test
    void d_delete() {
        boolean delete = service.delete(routeTicket.getRoute());
        assertTrue(delete);
    }

    @Test
    void getAll() {
        assertEquals(1, service.getAll());
        System.out.println("Get all ticket routes: " + "\n" + service.getAll() + "\n");
    }
}