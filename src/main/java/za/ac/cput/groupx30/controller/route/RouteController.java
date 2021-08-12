package za.ac.cput.groupx30.controller.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.service.route.impl.RouteServiceImpl;

@RestController()
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteServiceImpl service;

    @PostMapping("/create")
    public Route create(@RequestBody Route route) {
        Route newRoute = RouteFactory.createRoute(
                route.getId(),
                route.getDistance(),
                route.getTime()
        );
        return service.create(newRoute);
    }
}
