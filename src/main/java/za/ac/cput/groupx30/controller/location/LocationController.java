package za.ac.cput.groupx30.controller.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationFactory;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.service.location.LocationService;
import za.ac.cput.groupx30.service.route.RouteService;

import java.util.Set;

@RestController()
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Location create(@RequestBody Location location) {
        Location newLocation = LocationFactory.createLocation(location.getDescription(), location.getArea(), location.isPickupPoint());
        return service.create(newLocation);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Location read(@RequestBody Location id) {
        return service.read(id.getId());
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Location update(@RequestBody Location location) {
        return service.update(location);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Location id) {
        return service.delete(id.getId());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<Location> getAll() {
        return service.getAll();
    }
}
