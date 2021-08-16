package za.ac.cput.groupx30.service.routeTicket.imp;

import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.repository.routeTicket.RouteTicketRepository;
import za.ac.cput.groupx30.repository.routeTicket.imp.RouteTicketImpl;
import za.ac.cput.groupx30.service.routeTicket.RouteTicketService;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */

@Service
public class RouteTicketServiceImp implements RouteTicketService {
    public static RouteTicketService service = null;
    private RouteTicketRepository repository;


    private RouteTicketServiceImp(){this.repository = RouteTicketImpl.getRepository();}

    public static RouteTicketService getService(){
        if(service == null) service = new RouteTicketServiceImp();
        return service;
    }
    @Override
    public RouteTicket create(RouteTicket routeTicket) {
        return this.repository.create(routeTicket);
    }

    @Override
    public RouteTicket read(String routeID) {
        return this.read(routeID);
    }

    @Override
    public RouteTicket update(RouteTicket routeTicket) {
        return this.repository.update(routeTicket);
    }

    @Override
    public boolean delete(String routeID) {
        return this.repository.delete(routeID);
    }

    @Override
    public Set<RouteTicket> getAll() {
        return this.repository.getAll();
    }
}
