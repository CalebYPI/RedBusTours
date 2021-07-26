package za.ac.cput.groupx30.factory;
/**
 * Baron Mukenyi (217163742)
 * Class repository for Driver Route
 * 25 July 2021
 */

import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.util.Helper;

public class RouteTicketFactory {
    public static RouteTicket createTicker(String routeDesc){
        String route = Helper.generateId();

        RouteTicket routeTicket = new RouteTicket.Builder().setRoute(route).setRouteDesc(routeDesc).build();
        return routeTicket;
    }
}
