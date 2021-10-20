package za.ac.cput.groupx30.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.service.RouteService;

import java.util.Set;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService service;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("routes", service.getAll());
        return "routeHome";
    }

    @GetMapping("/create")
    public String getCreateForm(Route route) {
        return "routeAdd";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Route route, BindingResult result, Model model) {
        if (result.hasErrors())
            return "routeAdd";
        //Route newRoute = RouteFactory.createRoute(route.getDescription(), route.getDistance(), route.getTime());
        service.create(route);
        return "redirect:/route/home";
    }

    @GetMapping(value = "/read/{id}")
    public Route read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/update/{id}")
    public String getUpdateForm(@PathVariable("id") String id, Model model) {
        Route route = service.read(id);
        model.addAttribute("route", route);
        return "routeUpdate";
    }

    @PostMapping("/update")
    public String update(Route route, BindingResult result, Model model) {
        if (result.hasErrors())
            return "routeUpdate";
        service.update(route);
        return "redirect:/route/home";
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        service.delete(id);
        model.addAttribute("routes", service.getAll());
        return "redirect:/route/home";
    }

    @GetMapping(value = "/all")
    public Set<Route> getAll() {
        return service.getAll();
    }
}
