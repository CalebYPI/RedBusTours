package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.factory.LocationFactory;
import za.ac.cput.groupx30.service.LocationService;

import java.util.Set;

@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("locations", service.getAll());
        return "locationHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Location location) {
        return "locationAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Location location, BindingResult result, Model model) {
        if (result.hasErrors())
            return "locationAdd";
        Location newLocation = LocationFactory.createLocation(location.getDescription(), location.getArea(), location.isPickupPoint());
        service.create(newLocation);
        return "redirect:/location/home";
    }

    @GetMapping(value = "/read/{id}")
    public Location read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Location location = service.read(id);
        model.addAttribute("location", location);
        return "locationUpdate";
    }

    @PostMapping("/update")
    public String update(Location location, BindingResult result, Model model) {
        if (result.hasErrors())
            return "locationUpdate";
        service.update(location);
        return "redirect:/location/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        service.delete(id);
        model.addAttribute("locations", service.getAll());
        return "redirect:/location/home";
    }

    @GetMapping(value = "/all")
    public Set<Location> getAll() {
        return service.getAll();
    }
}
