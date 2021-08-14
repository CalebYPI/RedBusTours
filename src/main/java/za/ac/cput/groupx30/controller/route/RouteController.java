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

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Route read(@RequestBody Route id) {
        return service.read(id.getId());
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Route update(@RequestBody Route route) {
        return service.update(route);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Route id) {
        return service.delete(id.getId());
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Set<Route> getAll() {
        return service.getAll();
    }
}
