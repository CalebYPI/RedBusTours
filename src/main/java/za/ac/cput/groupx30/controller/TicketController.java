package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("tickets", service.getAll());
        return "ticketHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Ticket ticket) {
        return "ticketAdd";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors())
            return "ticketAdd";
        Ticket newTicket = TicketFactory.createTicket(ticket.getTime(), ticket.getDate(), ticket.getPrice());
        service.create(newTicket);
        return "redirect:/ticket/home";
    }

    @GetMapping(value = "/read/{id}")
    public Ticket read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") String id, Model model) {
        Ticket ticket = service.read(id);
        model.addAttribute("ticket", ticket);
        return "ticketUpdate";
    }

    @PostMapping(value = "/update")
    public String update(Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors())
            return "ticketUpdate";
        service.update(ticket);
        return "redirect:/ticket/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        service.delete(id);
        model.addAttribute("tickets", service.getAll());
        return "redirect:/ticket/home";
    }

    @GetMapping(value = "/all")
    public Set<Ticket> getAll() {
        return service.getAll();
    }
}
