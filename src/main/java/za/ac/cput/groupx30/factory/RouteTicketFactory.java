package za.ac.cput.groupx30.factory;

import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.util.Helper;

public class RouteTicketFactory {
    public static RouteTicket createTicker(String routeDesc){
        String route = Helper.generateId();

        RouteTicket routeTicket = new RouteTicket.Builder().setRoute(route).setRouteDesc(routeDesc).build();
        return routeTicket;
    }
}
