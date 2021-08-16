package za.ac.cput.groupx30.controller.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.tags.form.SelectTag;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationRouteFactory;
import za.ac.cput.groupx30.service.route.LocationRouteService;

import java.util.Set;

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
    public LocationRoute read(@RequestBody LocationRoute routeId){
        return service.read(routeId.getRouteId());
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public LocationRoute update(@RequestBody LocationRoute locationRoute) {
        LocationRoute updated = new LocationRoute.Builder().copy(locationRoute).setLocationId(locationRoute.getLocationId()).build();
        return service.update(updated);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody LocationRoute routeId){
        return service.delete(routeId.getRouteId());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<LocationRoute> getAll() {
        return service.getAll();
    }
}
