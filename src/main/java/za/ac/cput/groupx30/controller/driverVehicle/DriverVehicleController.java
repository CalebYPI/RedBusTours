package za.ac.cput.groupx30.controller.driverVehicle;

// Author: Thokozile Snono
// Student number: 216032121
// Controller: DriverVehicleController Class
// Date: 16 August 2021

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.factory.DriverVehicleFactory;
import za.ac.cput.groupx30.service.driverVehicle.DriverVehicleService;

import java.util.Set;

@RestController
@RequestMapping("/driverVehicle")
public class DriverVehicleController {

    @Autowired
    private DriverVehicleService driverVehicleService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DriverVehicle create(@RequestBody DriverVehicle driverVehicle) {
        DriverVehicle newDriverVehicle = DriverVehicleFactory.createDriverVehicle(driverVehicle.vehicleId);
        return driverVehicleService.create(newDriverVehicle);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public DriverVehicle read(@RequestBody DriverVehicle driverVehicleId) {
        return driverVehicleService.read(driverVehicleId.driverId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public DriverVehicle update(@RequestBody DriverVehicle driverVehicle) {
        return driverVehicleService.update(driverVehicle);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody DriverVehicle driverVehicle) {
        return driverVehicleService.delete(driverVehicle.driverId);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<DriverVehicle> getAll() {
        return driverVehicleService.getAll();
    }
}

