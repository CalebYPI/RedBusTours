package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationRouteFactory;
import za.ac.cput.groupx30.service.LocationService;
import za.ac.cput.groupx30.service.LocationRouteService;
import za.ac.cput.groupx30.service.RouteService;

import java.util.Set;

@Controller
@RequestMapping("/locationRoute")
public class LocationRouteController {

    @Autowired
    private LocationRouteService locationRouteService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private RouteService routeService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("location routes", locationRouteService.getAll());
        return "locationRouteHome";
    }

    @GetMapping("/create")
    public String getCreateForm(LocationRoute locationRoute) {
        return "locationRouteHome";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute LocationRoute locationRoute, BindingResult result, Model model) {
        if (result.hasErrors())
            return "locationRouteAdd";
        boolean routeExists = false;
        boolean locationExists = false;

        Route route = routeService.read(locationRoute.getRouteId());
        if (route != null)
            routeExists = true;

        Location location = locationService.read(locationRoute.getLocationId());
        if (location != null)
            locationExists = true;

        if (routeExists && locationExists)
            locationRouteService.save(locationRoute);
        else
            LocationRouteFactory.createLocationRoute("", "");
        return "redirect:/locationRoute/home";
    }

    @GetMapping(value = "/read/{routeId}/{locationId}")
    public LocationRoute read(@PathVariable String routeId, @PathVariable("locationId") String locationId) {
        LocationRoute.LocationRouteId id = new LocationRoute.LocationRouteId(routeId, locationId);
        return locationRouteService.read(id);
    }

    @GetMapping("/delete/{routeId}/{locationId}")
    public String delete(@PathVariable String routeId, @PathVariable("locationId") String locationId, Model model) {
        LocationRoute locationRoute = LocationRouteFactory.createLocationRoute(locationId, routeId);
        locationRouteService.delete(locationRoute);
        model.addAttribute("location routes", locationRouteService.getAll());
        return "redirect:/locationRoute/home";
    }

    @DeleteMapping(value = "/delete/{routeId}/{locationId}")
    public boolean delete(@PathVariable String routeId, @PathVariable("locationId") String locationId) {
        LocationRoute locationRoute = LocationRouteFactory.createLocationRoute(locationId, routeId);
        return locationRouteService.delete(locationRoute);
    }

    @GetMapping(value = "/all")
    public Set<LocationRoute> getAll() {
        return locationRouteService.getAll();
    }
}
