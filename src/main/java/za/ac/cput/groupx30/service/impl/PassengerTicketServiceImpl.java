package za.ac.cput.groupx30.service.impl;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Service Implementation for PassengerTicket
 * Date: 31 July 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.repository.PassengerTicketRepository;
//import za.ac.cput.groupx30.repository.impl.PassengerTicketRepositoryImpl;
import za.ac.cput.groupx30.service.PassengerTicketService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PassengerTicketServiceImpl implements PassengerTicketService {

    private static PassengerTicketServiceImpl service = null;

    @Autowired
    private PassengerTicketRepository repository;

    @Override
    public PassengerTicket create(PassengerTicket passengerTicket) {
        return this.repository.save(passengerTicket);
    }

    @Override
    public PassengerTicket read(String passengerId) {
        return this.repository.findById(passengerId).orElse(null);
    }

    @Override
    public PassengerTicket update(PassengerTicket passengerTicket) {
        if(this.repository.existsById(passengerTicket.getPassengerId())){
            return this.repository.save(passengerTicket);
        }
        return null;
    }

    @Override
    public boolean delete(String passengerId) {
        this.repository.deleteById(passengerId);
        if (this.repository.existsById(passengerId)) {
            return false;
        }
        else
            return true;
    }

    @Override
    public Set<PassengerTicket> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


//    private PassengerTicketRepository repository = null;

//    private PassengerTicketServiceImpl(){
//        this.repository = PassengerTicketRepositoryImpl.getRepository();
//    }
//
//    public static PassengerTicketServiceImpl getService(){
//        if(service == null) {
//            service = new PassengerTicketServiceImpl();
//        }
//        return service;
//    }
//
//    @Override
//    public PassengerTicket create(PassengerTicket passengerTicket) {
//        return this.repository.create(passengerTicket);
//    }
//
//    @Override
//    public PassengerTicket read(String passengerId, String ticketId) {
//        return this.repository.read(passengerId, ticketId);
//    }
//
//
//    @Override
//    public PassengerTicket update(PassengerTicket passengerTicket) {
//        return this.repository.update(passengerTicket);
//    }
//
//    @Override
//    public boolean delete(String passengerId, String ticketId) {
//        return this.repository.delete(passengerId, ticketId);
//    }
//
//    @Override
//    public Set<PassengerTicket> getAll() {
//        return this.repository.getAll();
//    }
}
