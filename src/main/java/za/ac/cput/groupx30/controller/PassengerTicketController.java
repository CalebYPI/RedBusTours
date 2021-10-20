package za.ac.cput.groupx30.controller;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Controller for PassengerTicket
 * Date: 15 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.factory.PassengerTicketFactory;
import za.ac.cput.groupx30.service.PassengerService;
import za.ac.cput.groupx30.service.PassengerTicketService;
import za.ac.cput.groupx30.service.TicketService;

import java.util.Set;

@Controller
@RequestMapping("/passengerTicket")
public class PassengerTicketController {
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private PassengerTicketService passengerTicketService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("passenger tickets", passengerTicketService.getAll());
        return "passengerTicketHome";
    }

    @GetMapping("/create")
    public String getCreateForm(PassengerTicket passengerTicket){
        return "passengerTicketHome";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute PassengerTicket passengerTicket, BindingResult result, Model model) {
        if (result.hasErrors())
            return "passengerTicketAdd";
        boolean passengerExist = false;
        boolean ticketExist = false;

        Passenger passenger = passengerService.read(passengerTicket.getPassengerId());
        if (passenger != null) {
            passengerExist = true;
        }
        Ticket ticket = ticketService.read(passengerTicket.getTicketId());
        if (ticket != null) {
            ticketExist = true;
        }
        if (passengerExist && ticketExist) {
            passengerTicketService.create(passengerTicket);
        } else
            PassengerTicketFactory.createPassengerTicket("","");
        return "redirect:/passengerTicket/home";
    }

    @GetMapping(value = "/read/{passengerId}/{ticketId}")
    public PassengerTicket read(@PathVariable String passengerId, @PathVariable("ticketId") String ticketId) {
        PassengerTicket.PassengerTicketId id = new PassengerTicket.PassengerTicketId(passengerId, ticketId);
        return passengerTicketService.read(id);
    }

    @GetMapping("/delete/{passengerId}/{ticketId}")
    public String delete(@PathVariable String passengerId, @PathVariable("ticketId") String ticketId, Model model){
        PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket(passengerId, ticketId);
        passengerTicketService.delete(passengerTicket);
        model.addAttribute("passenger tickets", passengerTicketService.getAll());
        return "redirect:/passengerTicket/home";
    }



    @DeleteMapping(value = "/delete/{passengerId}/{ticketId}")
    public boolean delete(@PathVariable String passengerId, @PathVariable("ticketId") String ticketId) {
        PassengerTicket passengerTicket = PassengerTicketFactory.createPassengerTicket(passengerId, ticketId);
        return passengerTicketService.delete(passengerTicket);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Set<PassengerTicket> getall() {
        return passengerTicketService.getAll();
    }

}
