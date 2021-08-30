package za.ac.cput.groupx30.controller;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Controller for Passenger
 * Date: 15 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.factory.PassengerFactory;
import za.ac.cput.groupx30.service.PassengerService;

import java.util.Set;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Passenger create(@RequestBody Passenger passenger){
        Passenger newPassenger = PassengerFactory.createPassenger(passenger.getName(), passenger.getContact());
        return passengerService.create(newPassenger);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Passenger read(@PathVariable String passengerId){
        return passengerService.read(passengerId);

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Passenger update(@RequestBody Passenger passenger){
        return passengerService.update(passenger);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String passengerId){
        return passengerService.delete(passengerId);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Set<Passenger> getall(){
        return passengerService.getAll();
    }

}
