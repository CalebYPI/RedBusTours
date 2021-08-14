package za.ac.cput.groupx30.controller.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationRouteFactory;
import za.ac.cput.groupx30.service.route.LocationRouteService;

@RestController()
@RequestMapping("/locationRoute")
public class LocationRouteController {

    @Autowired
    private LocationRouteService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public LocationRoute create(@RequestBody LocationRoute locationRoute){
        LocationRoute newLocationRoute = LocationRouteFactory.createLocationRoute(locationRoute.getLocationId(), locationRoute.getRouteId());
        return service.create(newLocationRoute);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public LocationRoute read(@RequestBody Location locationId, Route routeId){
        return service.read(locationId.getId(), routeId.getId());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Location locationId, Route routeId){
        return service.delete(locationId.getId(), routeId.getId());
    }
}
