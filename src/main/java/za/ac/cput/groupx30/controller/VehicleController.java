package za.ac.cput.groupx30.controller;

// Author: Thokozile Snono
// Student number: 216032121
// Controller: VehicleController Class
// Date: 16 August 2021

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.factory.VehicleFactory;
import za.ac.cput.groupx30.service.VehicleService;

import java.util.Set;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("vehicles", service.getAll());
        return "vehicleHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Vehicle vehicle) {
        return "vehicleAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Vehicle vehicle, BindingResult result, Model model) {
        if (result.hasErrors())
            return "vehicleAdd";
        Vehicle newVehicle = VehicleFactory.createVehicle(vehicle.getDesc());
        service.create(newVehicle);
        return "redirect:/vehicle/home";
    }

    @GetMapping(value = "/read/{id}")
    public Vehicle read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Vehicle vehicle = service.read(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicleUpdate";
    }

    @PostMapping("/update")
    public String update(Vehicle vehicle, BindingResult result, Model model) {
        if (result.hasErrors())
            return "vehicleUpdate";
        service.update(vehicle);
        return "redirect:/vehicle/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id")String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        service.delete(id);
        model.addAttribute("vehicle", service.getAll());
        return "redirect:/vehicle/home";
    }

    @GetMapping(value = "/all")
    public Set< Vehicle > getAll() {
        return service.getAll();
    }
}

