package za.ac.cput.groupx30.service.passengerTicket;

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
    PassengerTicket read(String passengerId, String ticketId);
    PassengerTicket update(PassengerTicket passengerTicket);

    boolean delete(String passengerId, String ticketId);
    public Set<PassengerTicket> getAll();
}
