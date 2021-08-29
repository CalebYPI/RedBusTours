package za.ac.cput.groupx30.factory;
/**
 * Baron Mukenyi (217163742)
 * Class repository for Driver Route
 * 25 July 2021
 */

import za.ac.cput.groupx30.entity.RouteTicket;

public class RouteTicketFactory {
    public static RouteTicket createTicket(String routeID, String ticketID){

        RouteTicket routeTicket = new RouteTicket.Builder().setRoute(routeID).setTicketID(ticketID).build();
        return routeTicket;
    }
}
