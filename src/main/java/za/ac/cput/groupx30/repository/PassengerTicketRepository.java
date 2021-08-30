package za.ac.cput.groupx30.repository;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Repository Interface for PassengerTicket
 * Date: 24 July 2021
 */

import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface PassengerTicketRepository{
    PassengerTicket create(PassengerTicket passengerTicket);
    PassengerTicket read(String passengerId, String ticketId);
    PassengerTicket update(PassengerTicket passengerTicket);

    boolean delete(String passengerId, String ticketId);
    public Set<PassengerTicket> getAll();

}
