package za.ac.cput.groupx30.factory;

import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.util.Helper;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Factory for Ticket
 * Date: 06 June 2021
 */
public class TicketFactory {

    public static Ticket createTicket(String date, String time, int price){
        String id = Helper.generateId();
        Ticket ticket = new Ticket.Builder()
                .setId(id)
                .setDate(date)
                .setTime(time)
                .setPrice(price)
                .build();
        return ticket;
    }
}
