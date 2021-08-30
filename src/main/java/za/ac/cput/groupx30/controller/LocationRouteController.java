package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationRouteFactory;
import za.ac.cput.groupx30.service.LocationService;
import za.ac.cput.groupx30.service.LocationRouteService;
import za.ac.cput.groupx30.service.RouteService;

import java.util.Set;

@RestController()
@RequestMapping("/locationRoute")
public class LocationRouteController {

    @Autowired
    private LocationRouteService locationRouteService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private RouteService routeService;

    @PostMapping(value = "/create")
    public LocationRoute create(@RequestBody LocationRoute locationRoute){
        boolean routeExists = false;
        boolean locationExists = false;

        Route route = routeService.read(locationRoute.getRouteId());
        if (route != null)
            routeExists = true;

        Location location = locationService.read(locationRoute.getLocationId());
        if (location != null)
            locationExists = true;

        if (routeExists && locationExists)
            return locationRouteService.save(locationRoute);
        else
            return LocationRouteFactory.createLocationRoute("", "");
    }

    @GetMapping(value = "/read/{routeId}/{locationId}")
    public LocationRoute read(@PathVariable String routeId, @PathVariable("locationId") String locationId){
        LocationRoute.LocationRouteId id = new LocationRoute.LocationRouteId(routeId, locationId);
        return locationRouteService.read(id);
    }

    @DeleteMapping(value = "/delete/{routeId}/{locationId}")
    public boolean delete(@PathVariable String routeId, @PathVariable("locationId") String locationId){
        LocationRoute locationRoute = LocationRouteFactory.createLocationRoute(locationId, routeId);
        return locationRouteService.delete(locationRoute);
    }

    @GetMapping(value = "/all")
    public Set<LocationRoute> getAll() {
        return locationRouteService.getAll();
    }
}
