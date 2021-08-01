package za.ac.cput.groupx30.service.routeTicket;

import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */


public interface RouteTicketService extends IService<RouteTicket, String> {
    Set<RouteTicket> getAll();
}
