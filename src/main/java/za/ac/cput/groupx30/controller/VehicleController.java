package za.ac.cput.groupx30.controller;

// Author: Thokozile Snono
// Student number: 216032121
// Controller: VehicleController Class
// Date: 16 August 2021

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.factory.VehicleFactory;
import za.ac.cput.groupx30.service.VehicleService;

import java.util.Set;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Vehicle create(@RequestBody Vehicle vehicle) {
        Vehicle vehicleNew = VehicleFactory.createVehicle(vehicle.getDesc(), vehicle.getId());
        return vehicleService.create(vehicleNew);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Vehicle read(@RequestBody Vehicle vehicleID) {
        return vehicleService.read(vehicleID.Id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Vehicle update(@RequestBody Vehicle vehicleID) {
        return vehicleService.update(vehicleID);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Vehicle vehicleID) {
        return vehicleService.delete(vehicleID.Id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set< Vehicle > getAll() {
        return vehicleService.getAll();
    }
}

