package za.ac.cput.groupx30.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.repository.RouteTicketRepository;
import za.ac.cput.groupx30.service.RouteTicketService;

import java.util.HashSet;
import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */

@Service
public class RouteTicketServiceImp implements RouteTicketService {
    public static RouteTicketService service = null;

   @Autowired
    private RouteTicketRepository repository;



    public static RouteTicketService getService(){
        if(service == null) service = new RouteTicketServiceImp();
        return service;
    }


    @Override
    public RouteTicket save(RouteTicket routeTicket) {
        return this.repository.save(routeTicket);
    }

    @Override
    public RouteTicket read(RouteTicket.RouteTicketID id) {
        return this.repository.getById(id);
    }

    @Override
    public boolean delete(RouteTicket routeTicket) {
        if(routeTicket!= null){
            this.repository.delete(routeTicket);
            return true;
        }
        return false;
    }

    @Override
    public Set<RouteTicket> getAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
