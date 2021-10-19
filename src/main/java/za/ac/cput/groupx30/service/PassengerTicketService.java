package za.ac.cput.groupx30.service;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Service Interface for PassengerTicket
 * Date: 31 July 2021
 */

import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface PassengerTicketService {

    PassengerTicket create(PassengerTicket passengerTicket);

    PassengerTicket read(PassengerTicket.PassengerTicketId id);

    boolean delete(PassengerTicket passengerTicket);

    Set<PassengerTicket> getAll();

    Set<PassengerTicket> findAllByTicketId(String ticketId);
}
