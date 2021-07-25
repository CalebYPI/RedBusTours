package za.ac.cput.groupx30.repository.driverRoute;

// Author: Thokozile Snono
// Student number: 216032121
// Entity: DriverRouteRepository
// Date: 26 July 2021

import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface DriverRouteRepository extends IRepository< DriverRoute, String> {
    Set<DriverRoute> getAll();
}
