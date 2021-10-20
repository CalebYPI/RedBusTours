package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

@Controller
@RequestMapping("/routeTicket")
public class RouteTicketController {
    @Autowired
    private RouteTicketService service;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private RouteService routeService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("route tickets", service.getAll());
        return "routeTicketHome";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute RouteTicket routeTicket, BindingResult result, Model model) {
        if (result.hasErrors())
            return "routeTicketAdd";
        boolean ticketExist = false;
        boolean routeExist = false;
        Route route = routeService.read(routeTicket.getRoute());
        if (route != null)
            routeExist = true;

        Ticket ticket = ticketService.read(routeTicket.getTicketID());
        if (ticket != null)
            ticketExist = true;

        if (routeExist && ticketExist)
            service.save(routeTicket);
        else
            RouteTicketFactory.createTicket("", "");
        return "redirect:/routeTicket/home";
    }

    @GetMapping(value = "/read/{routeID}/{ticketID}")
    public RouteTicket read(@PathVariable String routeID, @PathVariable("ticketID") String ticketID) {
        RouteTicket.RouteTicketID id = new RouteTicket.RouteTicketID(routeID, ticketID);
        return service.read(id);
    }

    @DeleteMapping(value = "/delete/{routeID}/{ticketID}")
    public boolean delete(@PathVariable String routeID, @PathVariable("ticketID") String ticketID) {
        RouteTicket routeTicket = RouteTicketFactory.createTicket(routeID, ticketID);
        return service.delete(routeTicket);
    }

    @GetMapping(value = "/delete/{routeID}/{ticketID}")
    public String delete(@PathVariable("routeId") String routeID, @PathVariable("ticketID") String ticketID, Model model) {
        RouteTicket routeTicket = RouteTicketFactory.createTicket(routeID, ticketID);
        service.delete(routeTicket);
        model.addAttribute("route tickets", service.getAll());
        return "redirect:/routeTicket/home";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<RouteTicket> getAll() {
        return service.getAll();
    }
}
