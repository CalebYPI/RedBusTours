package za.ac.cput.groupx30.service.vehicle;

import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface VehicleService extends IService<Vehicle, String> {
    Set<Vehicle> getAll();
}
