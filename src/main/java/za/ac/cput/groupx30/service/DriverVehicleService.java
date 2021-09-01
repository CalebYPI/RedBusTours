package za.ac.cput.groupx30.service;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverVehicleService Class
// Date: 02 August 2021

import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface DriverVehicleService {
    DriverVehicle create(DriverVehicle driverVehicle);
    DriverVehicle read(DriverVehicle.DriverVehicleId id);
    boolean delete(DriverVehicle driverVehicle);
    Set<DriverVehicle> getAll();

    Set<DriverVehicle> getAllStartWithM();
}
