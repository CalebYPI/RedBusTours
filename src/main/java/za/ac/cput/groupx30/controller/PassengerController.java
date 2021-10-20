package za.ac.cput.groupx30.controller;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Controller for Passenger
 * Date: 15 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.factory.PassengerFactory;
import za.ac.cput.groupx30.service.PassengerService;

import java.util.Set;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("passengers", passengerService.getAll());
        return "passengerHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Passenger passenger){
        return "passengerAdd";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Passenger passenger, BindingResult result, Model model) {
        if (result.hasErrors())
            return "passengerAdd";
        Passenger newPassenger = PassengerFactory.createPassenger(passenger.getName(), passenger.getContact());
        passengerService.create(newPassenger);
        return "redirect:/passenger/home";
    }

    @GetMapping(value = "/read{passengerId}")
    public Passenger read(@PathVariable String passengerId) {
        return passengerService.read(passengerId);

    }

    @PostMapping(value = "/update")
    public String update(Passenger passenger, BindingResult result, Model model) {
        if (result.hasErrors())
            return "passengerUpate";
        passengerService.update(passenger);
        return "redirect:/passenger/home";
    }

    @DeleteMapping(value = "/delete/{passengerId}")
    public boolean delete(@PathVariable("passengerId") String passengerId) {
        return passengerService.delete(passengerId);
    }

    @GetMapping("/delete/passengerId}")
    public String delete(@PathVariable("passengerId") String passengerId, Model model){
        passengerService.delete(passengerId);
        model.addAttribute("passenger", passengerService.getAll());
        return "redirect:/passenger/home";
    }

    @GetMapping(value = "/getall")
    public Set<Passenger> getall() {
        return passengerService.getAll();
    }

}
