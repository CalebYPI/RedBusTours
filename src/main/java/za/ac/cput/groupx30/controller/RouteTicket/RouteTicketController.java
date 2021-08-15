package za.ac.cput.groupx30.controller.RouteTicket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.groupx30.entity.RouteTicket;
import za.ac.cput.groupx30.factory.RouteTicketFactory;
import za.ac.cput.groupx30.service.routeTicket.RouteTicketService;

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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RouteTicket create(@RequestBody RouteTicket routeTicket){
        RouteTicket newRouteTicket = RouteTicketFactory.createTicker(routeTicket.getRouteDesc());
        return service.create(newRouteTicket);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public RouteTicket read(@RequestBody RouteTicket id){
        return service.read(id.getRoute());
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public RouteTicket update(@RequestBody RouteTicket routeTicket){
        return service.update(routeTicket);
    }

    @RequestMapping(value = "/read", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody RouteTicket id){
        return service.delete(id.getRoute());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<RouteTicket> getAll(){
        return service.getAll();
    }
}
