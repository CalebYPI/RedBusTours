package za.ac.cput.groupx30.repository.routeTicket;

import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class repository for TicketRoute
 * 25 July 2021
 */

public interface RouteTicketRepository extends IRepository<RouteTicket, String> {
    Set<RouteTicket> getAll();
}
