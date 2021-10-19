package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.factory.TicketFactory;
import za.ac.cput.groupx30.service.TicketService;

/**
 * Baron Mukenyi (217163742)
 * Class for TicketController
 * 13 August 2021
 */
import java.util.Set;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService service;

    @PostMapping(value = "/create")
    public Ticket create(@RequestBody Ticket ticket) {
        Ticket newTicket = TicketFactory.createTicket(ticket.getTime(), ticket.getDate(), ticket.getPrice());
        return service.create(newTicket);
    }

    @GetMapping(value = "/read/{id}")
    public Ticket read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping(value = "/update")
    public Ticket update(@RequestBody Ticket ticket) {
        return service.update(ticket);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping(value = "/all")
    public Set<Ticket> getAll() {
        return service.getAll();
    }
}
