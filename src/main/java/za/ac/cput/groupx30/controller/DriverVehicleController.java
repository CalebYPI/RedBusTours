package za.ac.cput.groupx30.controller;

// Author: Thokozile Snono
// Student number: 216032121
// Controller: DriverVehicleController Class
// Date: 16 August 2021

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DriverVehicle create(@RequestBody DriverVehicle driverVehicle) {
        boolean driverExists = false;
        boolean vehicleExists = false;

        Driver driver = driverService.read(driverVehicle.driverId);
        if (driver != null)
            driverExists = true;

        Vehicle vehicle = vehicleService.read(driverVehicle.vehicleId);
        if (vehicle != null)
            vehicleExists = true;

        if (driverExists && vehicleExists)
            return driverVehicleService.create(driverVehicle);
        else
            return DriverVehicleFactory.createDriverVehicle("", "");
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public DriverVehicle read(@RequestBody DriverVehicle.DriverVehicleId driverVehicleId) {
        return driverVehicleService.read(driverVehicleId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody DriverVehicle driverVehicle) {
        return driverVehicleService.delete(driverVehicle);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<DriverVehicle> getAll() {
        return driverVehicleService.getAll();
    }
}

