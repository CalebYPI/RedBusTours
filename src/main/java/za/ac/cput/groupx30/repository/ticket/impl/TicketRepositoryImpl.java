package za.ac.cput.groupx30.repository.ticket.impl;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Repository Implementation for Ticket
 * Date: 24 July 2021
 */

import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.repository.ticket.TicketRepository;

import java.util.HashSet;
import java.util.Set;

public class TicketRepositoryImpl implements TicketRepository {
    private static TicketRepositoryImpl repository = null;
    private Set<Ticket> ticketDB = null;

    private TicketRepositoryImpl(){
        ticketDB = new HashSet<Ticket>();
    }

    public static TicketRepositoryImpl getRepository(){
        if (repository == null) {
            repository = new TicketRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Ticket create(Ticket ticket) {
        boolean created = ticketDB.add(ticket);
        if (!created){
            return null;
        }
        return ticket;
    }

    @Override
    public Ticket read(String ticketId) {
        for(Ticket t : ticketDB){
            if(t.getId().equals(ticketId)){
                return t;
            }
        }
        return null;
    }

    @Override
    public Ticket update(Ticket ticket) {
        Ticket oldTicket = read(ticket.getId());
        if(oldTicket != null){
            ticketDB.remove(oldTicket);
            ticketDB.add(ticket);
            return ticket;
        }
        return null;
    }

    @Override
    public boolean delete(String ticketId) {
        Ticket deleteTicket = read(ticketId);
        if(deleteTicket == null){
            return false;
        }
        ticketDB.remove(deleteTicket);
        return true;
    }

    @Override
    public Set<Ticket> getAll() {
        return ticketDB;
    }
}
