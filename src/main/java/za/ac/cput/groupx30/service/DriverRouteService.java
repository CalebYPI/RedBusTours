package za.ac.cput.groupx30.service;


import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;


/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */
public interface DriverRouteService extends IService<DriverRoute, String> {
    Set<DriverRoute> getAll();
}
