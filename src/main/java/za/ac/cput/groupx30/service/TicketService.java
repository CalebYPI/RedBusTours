package za.ac.cput.groupx30.service;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Service Interface for Ticket
 * Date: 31 July 2021
 */

import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface TicketService extends IService<Ticket, String> {
    Set<Ticket> getAll();
}
