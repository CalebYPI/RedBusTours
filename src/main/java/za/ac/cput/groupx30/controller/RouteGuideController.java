package za.ac.cput.groupx30.controller;

/* Thaakir Ajouhaar - 217244394
 * RouteGuide Controller
 *  16 August 2021
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.factory.RouteGuideFactory;
import za.ac.cput.groupx30.service.RouteGuideService;

import java.util.Set;

@Controller
@RequestMapping("/routeGuide")
public class RouteGuideController {
    @Autowired
    private RouteGuideService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("route Guides", service.getAll());
        return "/routeGuideHome";
    }

    @GetMapping("/create")
    public String getCreateForm(RouteGuide routeGuide) {
        return "routeGuideAdd";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute RouteGuide routeGuide, BindingResult result, Model model) {
        if (result.hasErrors())
            return "routeGuideAdd";
        RouteGuide newRouteGuide = RouteGuideFactory.createRouteGuide(routeGuide.getRouteId(), routeGuide.getGuideId());
        service.create(newRouteGuide);
        return "redirect:/routeGuide/home";
    }

    @GetMapping(value = "/read/{routeId}")
    public RouteGuide read(@PathVariable RouteGuide.RouteGuideId routeId) {
        return service.read(routeId);
    }

    @DeleteMapping(value = "/delete/{routeId}")
    public boolean delete(@PathVariable RouteGuide routeId) {
        return service.delete(routeId);
    }

    @GetMapping("/delete/{routeId}")
    public String delete(@PathVariable RouteGuide routeId, Model model)
    {
        service.delete(routeId);
        model.addAttribute("route guides", service.getAll());
        return "redirect:/routeGuide/home";
    }

    @GetMapping(value = "/all")
    public Set<RouteGuide> getAll() {
        return service.getAll();
    }
}