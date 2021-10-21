package za.ac.cput.groupx30.service.impl;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Service Implementation for Ticket
 * Date: 31 July 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.factory.TicketFactory;
import za.ac.cput.groupx30.repository.TicketRepository;
import za.ac.cput.groupx30.service.TicketService;

import java.util.HashSet;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {
    private static TicketServiceImpl service = null;
    @Autowired
    private TicketRepository repository = null;


    public static TicketServiceImpl getService() {
        if (service == null) {
            service = new TicketServiceImpl();
        }
        return service;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return this.repository.save(ticket);
    }

    @Override
    public Ticket read(String ticketId) {
        return this.repository.getById(ticketId);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return this.repository.save(ticket);
    }

    @Override
    public boolean delete(String ticketId) {
        this.repository.deleteById(ticketId);
        return !this.repository.existsById(ticketId);
    }

    @Override
    public Set<Ticket> getAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
