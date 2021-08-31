package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.service.DriverService;

import java.util.Set;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping(value = "/create")
    public Driver create(@RequestBody Driver driver) {
        return service.create(driver);
    }

    @GetMapping(value = "/read/{id}")
    public Driver read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Driver update(@RequestBody Driver driver) {
        return service.update(driver);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/all")
    public Set<Driver> getAll() {
        return service.getAll();
    }
}
