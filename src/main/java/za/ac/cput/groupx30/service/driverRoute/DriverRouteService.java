package za.ac.cput.groupx30.service.driverRoute;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverRouteService Interface
// Date: 02 August 2021

import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface DriverRouteService extends IService < DriverRoute, String > {
    Set<DriverRoute> getAll();

    //Set<DriverRoute> getAllStartWithB();
}
