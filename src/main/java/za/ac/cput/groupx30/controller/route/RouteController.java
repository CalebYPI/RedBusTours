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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Route create(@RequestBody Route route) {
        Route newRoute = RouteFactory.createRoute(route.getDescription(), route.getDistance(), route.getTime());
        return service.create(newRoute);
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public Route read(@PathVariable String id) {
        return service.read(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Route update(@RequestBody Route route) {
        return service.update(route);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String id) {
        return service.delete(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<Route> getAll() {
        return service.getAll();
    }
}
