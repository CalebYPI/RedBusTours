package za.ac.cput.groupx30.service.driverVehicle;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverVehicleService Class
// Date: 02 August 2021

import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface DriverVehicleService extends IService < DriverVehicle, String > {
    Set<DriverVehicle> getAll();

    Set<DriverVehicle> getAllStartWithM();
}
