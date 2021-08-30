package za.ac.cput.groupx30.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class repository for TicketRoute
 * 25 July 2021
 */

public interface RouteTicketRepository extends JpaRepository<RouteTicket, RouteTicket.RouteTicketID> {
    //Set<RouteTicket> getAll();
}
