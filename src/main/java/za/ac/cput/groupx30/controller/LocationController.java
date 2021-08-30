package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.factory.LocationFactory;
import za.ac.cput.groupx30.service.LocationService;

import java.util.Set;

@RestController()
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService service;

    @PostMapping(value = "/create")
    public Location create(@RequestBody Location location) {
        Location newLocation = LocationFactory.createLocation(location.getDescription(), location.getArea(), location.isPickupPoint());
        return service.create(newLocation);
    }

    @GetMapping(value = "/read/{id}")
    public Location read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping(value = "/update")
    public Location update(@RequestBody Location location) {
        return service.update(location);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping(value = "/all")
    public Set<Location> getAll() {
        return service.getAll();
    }
}
