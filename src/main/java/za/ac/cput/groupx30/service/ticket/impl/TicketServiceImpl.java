package za.ac.cput.groupx30.service.ticket.impl;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Service Implementation for Ticket
 * Date: 31 July 2021
 */

import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.repository.ticket.TicketRepository;
import za.ac.cput.groupx30.repository.ticket.impl.TicketRepositoryImpl;
import za.ac.cput.groupx30.service.ticket.TicketService;

import java.util.Set;

public class TicketServiceImpl implements TicketService {
    private static TicketServiceImpl service = null;
    private TicketRepository repository = null;

    private TicketServiceImpl(){
        this.repository = TicketRepositoryImpl.getRepository();
    }

    public static TicketServiceImpl getService(){
        if(service == null) {
            service = new TicketServiceImpl();
        }
        return service;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return this.repository.create(ticket);
    }

    @Override
    public Ticket read(String ticketId) {
        return this.repository.read(ticketId);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return this.repository.update(ticket);
    }

    @Override
    public boolean delete(String ticketId) {
        return this.repository.delete(ticketId);
    }

    @Override
    public Set<Ticket> getAll() {
        return this.repository.getAll();
    }
}
