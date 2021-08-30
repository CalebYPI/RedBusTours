package za.ac.cput.groupx30.service;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */


import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.factory.RouteTicketFactory;
import za.ac.cput.groupx30.service.routeTicket.RouteTicketService;
import za.ac.cput.groupx30.service.routeTicket.imp.RouteTicketServiceImp;

import static org.junit.jupiter.api.Assertions.*;

class RouteTicketServiceImpTest {

    private RouteTicketService service = RouteTicketServiceImp.getService();
    private static RouteTicket routeTicket = RouteTicketFactory.createTicket("To Johannesburg", "");

    @Test
    void a_create() {
        RouteTicket create = service.save(routeTicket);
        assertEquals(routeTicket.getRoute(), create.getTicketID());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {

        RouteTicket.RouteTicketID id = new RouteTicket.RouteTicketID(routeTicket.getRoute(), routeTicket.getTicketID());
        RouteTicket read = service.read(id);
        System.out.println("Read: " + read);
    }


    @Test
    void d_delete() {
        boolean delete = service.delete(routeTicket);
        assertTrue(delete);
    }

    @Test
    void e_getAll() {
        assertEquals(1, service.getAll());
        System.out.println("Get all ticket routes: " + "\n" + service.getAll() + "\n");
    }
}