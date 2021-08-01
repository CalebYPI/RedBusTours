package za.ac.cput.groupx30.service.routeTicket.imp;

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


public class RouteTicketServiceImp implements RouteTicketService {
    private RouteTicketRepository repository;
    private static RouteTicketServiceImp service;

    private RouteTicketServiceImp(){
        this.repository = RouteTicketImpl.getRepository();
    }

    public static RouteTicketServiceImp getService(){
        if(service == null){
            service = new RouteTicketServiceImp();
        }
        return null;
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
