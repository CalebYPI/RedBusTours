package za.ac.cput.groupx30.controller.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.service.route.RouteService;

import java.util.Set;

@RestController()
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService service;

    @PostMapping(value = "/create")
    public Route create(@RequestBody Route route) {
        Route newRoute = RouteFactory.createRoute(route.getDescription(), route.getDistance(), route.getTime());
        return service.create(newRoute);
    }

    @GetMapping(value = "/read/{id}")
    public Route read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping(value = "/update")
    public Route update(@RequestBody Route route) {
        return service.update(route);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping(value = "/all")
    public Set<Route> getAll() {
        return service.getAll();
    }
}
