package za.ac.cput.groupx30.service.vehicle;

// Author: Thokozile Snono
// Student number: 216032121
// Service: VehicleService Class
// Date: 02 August 2021

import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface VehicleService extends IService<Vehicle, String> {
    Set<Vehicle> getAll();
}
