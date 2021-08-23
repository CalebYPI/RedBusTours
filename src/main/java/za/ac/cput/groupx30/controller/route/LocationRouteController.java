package za.ac.cput.groupx30.controller.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationRouteFactory;
import za.ac.cput.groupx30.service.location.LocationService;
import za.ac.cput.groupx30.service.route.LocationRouteService;
import za.ac.cput.groupx30.service.route.RouteService;

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
            return locationRouteService.create(locationRoute);
        else
            return LocationRouteFactory.createLocationRoute("","");
    }

    @GetMapping(value = "/read/{routeId}")
    public LocationRoute read(@PathVariable String routeId){
        return locationRouteService.read(routeId);
    }

    @PutMapping(value = "/update")
    public LocationRoute update(@RequestBody LocationRoute locationRoute) {
        LocationRoute updated = new LocationRoute.Builder().copy(locationRoute).setLocationId(locationRoute.getLocationId()).build();
        return locationRouteService.update(updated);
    }

    @DeleteMapping(value = "/delete/{routeId}")
    public boolean delete(@PathVariable String routeId){
        return locationRouteService.delete(routeId);
    }

    @GetMapping(value = "/all")
    public Set<LocationRoute> getAll() {
        return locationRouteService.getAll();
    }
}
