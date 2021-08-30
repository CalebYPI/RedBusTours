package za.ac.cput.groupx30.factory;
/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: TestCase for TicketFactory
 * Date: 06 June 2021
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketFactoryTest {

    @Test
    void createTicket() {
        Ticket ticket = TicketFactory.createTicket("06/06/2021","15:00", 250);
        System.out.println(ticket);
    }
}