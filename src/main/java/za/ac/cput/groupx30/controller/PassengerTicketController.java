package za.ac.cput.groupx30.controller;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Controller for PassengerTicket
 * Date: 15 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.factory.PassengerTicketFactory;
import za.ac.cput.groupx30.service.PassengerService;
import za.ac.cput.groupx30.service.PassengerTicketService;
import za.ac.cput.groupx30.service.TicketService;

import java.util.Set;
@RestController
@RequestMapping("/passengerTicket")
public class PassengerTicketController {
    @Autowired
    private PassengerService passengerService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private PassengerTicketService passengerTicketService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public PassengerTicket create(@RequestBody PassengerTicket passengerTicket){
        boolean passengerExist = false;
        boolean ticketExist = false;

        Passenger passenger = passengerService.read(passengerTicket.getPassengerId());
        if(passenger != null){
            passengerExist = true;
        }
        Ticket ticket = ticketService.read(passengerTicket.getTicketId());
        if(ticket != null){
            ticketExist = true;
        }
        if (passengerExist && ticketExist){
            return passengerTicketService.create(passengerTicket);
        }
        else return PassengerTicketFactory.createPassengerTicket("", "");
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public PassengerTicket read(@PathVariable String passengerId, @PathVariable("ticketId") String ticketId){
        PassengerTicket.PassengerTicketId id = new PassengerTicket.PassengerTicketId(passengerId, ticketId);
        return passengerTicketService.read(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String ticketId){
        return passengerService.delete(ticketId);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Set<PassengerTicket> getall(){
        return passengerTicketService.getAll();
    }

}
