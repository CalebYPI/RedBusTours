package za.ac.cput.groupx30.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.factory.DriverRouteFactory;
import za.ac.cput.groupx30.service.DriverRouteService;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 13 August 2021
 */

@Controller
@RequestMapping("/driverRoute")
public class DriverRouteController {
    @Autowired
    private DriverRouteService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DriverRoute create(@RequestBody DriverRoute driverRoute) {
        DriverRoute newDriverRoute = DriverRouteFactory.createRoute(driverRoute.getDriverID(), driverRoute.getRouteID());
        return service.create(newDriverRoute);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public DriverRoute read(@RequestBody DriverRoute.DriverRouteId id) {
        return service.read(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody DriverRoute routeID) {
        return service.delete(routeID);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<DriverRoute> getAll() {
        return service.getAll();
    }
}
