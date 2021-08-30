package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.factory.RouteTicketFactory;
import za.ac.cput.groupx30.service.RouteService;
import za.ac.cput.groupx30.service.RouteTicketService;
import za.ac.cput.groupx30.service.TicketService;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 13 August 2021
 */

@RestController
@RequestMapping("/routeTicket")
public class RouteTicketController {
    @Autowired
    private RouteTicketService service;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private RouteService routeService;

    @PostMapping(value = "/create")
    public RouteTicket create(@RequestBody RouteTicket routeTicket){
        boolean ticketExist = false;
        boolean routeExist = false;
        Route route = routeService.read(routeTicket.getRoute());
        if(route != null)
            routeExist = true;

        Ticket ticket = ticketService.read(routeTicket.getTicketID());
        if(ticket != null)
            ticketExist = true;

        if(routeExist && ticketExist)
            return service.save(routeTicket);
        else
            return RouteTicketFactory.createTicket("","");
    }

    @GetMapping(value = "/read/{routeID}/{ticketID}")
    public RouteTicket read(@PathVariable String routeID, @PathVariable ("ticketID") String ticketID) {
        RouteTicket.RouteTicketID id = new RouteTicket.RouteTicketID(routeID, ticketID);
        return service.read(id);
    }

    @DeleteMapping(value = "/delete/{routeID}/{ticketID}")
    public boolean delete(@PathVariable String routeID, @PathVariable("ticketID") String ticketID){
        RouteTicket routeTicket = RouteTicketFactory.createTicket(routeID, ticketID);
        return service.delete(routeTicket);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<RouteTicket> getAll(){
        return service.getAll();
    }
}
