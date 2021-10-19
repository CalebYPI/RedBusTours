package za.ac.cput.groupx30.service;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Test cases for TicketService
 * Date: 31 July 2021
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.factory.TicketFactory;
import za.ac.cput.groupx30.service.impl.TicketServiceImpl;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TicketServiceImplTest {

    private TicketServiceImpl service = TicketServiceImpl.getService();
    private static Ticket ticket = TicketFactory.createTicket("12/1/2021", "12:52", 200);

    @Test
    void a_create() {
        Ticket created = service.create(ticket);
        assertEquals(created.getId(), ticket.getId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Ticket read = service.read(ticket.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Ticket updated = new Ticket.Builder().copy(ticket).setDate("21/07/2021").setTime("16:00").setPrice(250).build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(ticket.getId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }

}