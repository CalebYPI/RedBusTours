package za.ac.cput.groupx30.controller.DriverRoute;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.factory.DriverRouteFactory;
import za.ac.cput.groupx30.service.driverRoute.DriverRouteService;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 13 August 2021
 */

@RestController()
@RequestMapping("/driverRoute")
public class DriverRouteController {
    @Autowired
    private DriverRouteService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public DriverRoute create(@RequestBody DriverRoute driverRoute){
        DriverRoute newDriverRoute = DriverRouteFactory.createRoute(driverRoute.getDriverID());
        return service.create(newDriverRoute);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public DriverRoute read(@RequestBody DriverRoute id){
        return service.read(id.getRouteID());
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public DriverRoute update(@RequestBody DriverRoute driverRoute){
        return service.update(driverRoute);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody DriverRoute routeID){
        return service.delete(routeID.getRouteID());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<DriverRoute> getAll(){
        return service.getAll();
    }
}
