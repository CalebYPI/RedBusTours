package za.ac.cput.groupx30.controller;


import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.factory.DriverRouteFactory;
import za.ac.cput.groupx30.service.DriverRouteService;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 13 August 2021
 */

@Controller
@RequestMapping("/driverRoute")
public class DriverRouteController {
    @Autowired
    private DriverRouteService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("driver routes", service.getAll());
        return "driverRouteHome";
    }

    @GetMapping("/create")
    public String getCreateForm(DriverRoute driverRoute){
        return "driverRouteAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute DriverRoute driverRoute, BindingResult result, Model model) {
        if (result.hasErrors())
            return "driverRouteAdd";
        DriverRoute newDriverRoute = DriverRouteFactory.createRoute(driverRoute.getDriverID(), driverRoute.getRouteID());
        service.create(newDriverRoute);
        return "redirect:/driverRoute/home";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public DriverRoute read(@RequestBody DriverRoute.DriverRouteId id) {
        return service.read(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody DriverRoute routeID) {
        return service.delete(routeID);
    }

    @GetMapping("/delete/{driverid}/{routeid}")
    public String delete(@PathVariable("id") String driverId, String id, Model model) {
        model.addAttribute("driver routes", service.getAll());
        return "redirect:/driverRouteHome";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<DriverRoute> getAll() {
        return service.getAll();
    }
}
