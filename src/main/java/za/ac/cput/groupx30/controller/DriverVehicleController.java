package za.ac.cput.groupx30.controller;

// Author: Thokozile Snono
// Student number: 216032121
// Controller: DriverVehicleController Class
// Date: 16 August 2021

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.factory.DriverFactory;
import za.ac.cput.groupx30.factory.DriverVehicleFactory;
import za.ac.cput.groupx30.service.DriverService;
import za.ac.cput.groupx30.service.DriverVehicleService;
import za.ac.cput.groupx30.service.VehicleService;

import java.util.Set;

@Controller
@RequestMapping("/driverVehicle")
public class DriverVehicleController {

    @Autowired
    private DriverVehicleService driverVehicleService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("driver vehicles", driverVehicleService.getAll());
        return "driverVehicleHome";
    }

    @GetMapping("/create")
    public String getCreateForm(DriverVehicle driverVehicle) {
        return "driverVehicleAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute DriverVehicle driverVehicle, BindingResult result, Model model) {
        if (result.hasErrors())
            return "driverVehicleAdd";
        boolean driverExists = false;
        boolean vehicleExists = false;

        Driver driver = driverService.read(driverVehicle.driverId);
        if (driver != null)
            driverExists = true;

        Vehicle vehicle = vehicleService.read(driverVehicle.vehicleId);
        if (vehicle != null)
            vehicleExists = true;

        if (driverExists && vehicleExists)
            driverVehicleService.create(driverVehicle);
        else
            DriverVehicleFactory.createDriverVehicle("", "");
        return "redirect:/driverVehicle/home";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public DriverVehicle read(@RequestBody DriverVehicle.DriverVehicleId driverVehicleId) {
        return driverVehicleService.read(driverVehicleId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody DriverVehicle driverVehicle) {
        return driverVehicleService.delete(driverVehicle);
    }

    @GetMapping("/delete")

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<DriverVehicle> getAll() {
        return driverVehicleService.getAll();
    }
}

