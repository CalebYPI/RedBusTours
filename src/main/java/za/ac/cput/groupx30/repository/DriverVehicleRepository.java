package za.ac.cput.groupx30.repository;

// Author: Thokozile Snono
// Student number: 216032121
// Entity: DriverVehicleRepository
// Date: 26 July 2021

import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface DriverVehicleRepository extends IRepository< DriverVehicle, String> {
    Set<DriverVehicle> getAll();
}
