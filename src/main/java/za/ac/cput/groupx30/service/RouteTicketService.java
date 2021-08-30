package za.ac.cput.groupx30.service;

import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */


public interface RouteTicketService {
    RouteTicket save(RouteTicket routeTicket);
    RouteTicket read(RouteTicket.RouteTicketID id);
    boolean delete(RouteTicket routeTicket);
    Set<RouteTicket> getAll();
}
