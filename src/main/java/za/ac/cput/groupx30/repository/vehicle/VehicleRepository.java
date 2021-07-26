package za.ac.cput.groupx30.repository.vehicle;

import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface VehicleRepository extends IRepository<Vehicle, String> {
    Set<Vehicle> getAll();
}
