package za.ac.cput.groupx30.controller.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.service.route.RouteService;

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


}
