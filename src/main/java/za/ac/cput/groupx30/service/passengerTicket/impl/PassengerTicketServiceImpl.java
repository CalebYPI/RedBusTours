package za.ac.cput.groupx30.service.passengerTicket.impl;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Service Implementation for PassengerTicket
 * Date: 31 July 2021
 */

import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.repository.passengerTicket.PassengerTicketRepository;
import za.ac.cput.groupx30.repository.passengerTicket.impl.PassengerTicketRepositoryImpl;
import za.ac.cput.groupx30.service.passengerTicket.PassengerTicketService;

import java.util.Set;

public class PassengerTicketServiceImpl implements PassengerTicketService {
    private static PassengerTicketServiceImpl service = null;
    private PassengerTicketRepository repository = null;

    private PassengerTicketServiceImpl(){
        this.repository = PassengerTicketRepositoryImpl.getRepository();
    }

    public static PassengerTicketServiceImpl getService(){
        if(service == null) {
            service = new PassengerTicketServiceImpl();
        }
        return service;
    }

    @Override
    public PassengerTicket create(PassengerTicket passengerTicket) {
        return this.repository.create(passengerTicket);
    }

    @Override
    public PassengerTicket read(String passengerId, String ticketId) {
        return this.repository.read(passengerId, ticketId);
    }


    @Override
    public PassengerTicket update(PassengerTicket passengerTicket) {
        return this.repository.update(passengerTicket);
    }

    @Override
    public boolean delete(String passengerId, String ticketId) {
        return this.repository.delete(passengerId, ticketId);
    }

    @Override
    public Set<PassengerTicket> getAll() {
        return this.repository.getAll();
    }
}
