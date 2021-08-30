package za.ac.cput.groupx30.controller;

/* Thaakir Ajouhaar - 217244394
 * RouteGuide Controller
 *  16 August 2021
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.factory.RouteGuideFactory;
import za.ac.cput.groupx30.service.RouteGuideService;

import java.util.Set;

@RestController()
@RequestMapping("/routeGuide")
public class RouteGuideController
{
    @Autowired
    private RouteGuideService service;

    @PostMapping(value = "/create")
    public RouteGuide create(@RequestBody RouteGuide routeGuide)
    {
        RouteGuide newRouteGuide = RouteGuideFactory.createRouteGuide(routeGuide.getRouteId(), routeGuide.getGuideId());
        return service.create(newRouteGuide);
    }

    @GetMapping(value = "/read/{routeId}")
    public RouteGuide read(@PathVariable String routeId)
    {
        return service.read(routeId);
    }

    @DeleteMapping(value = "/delete/{routeId}")
    public boolean delete(@PathVariable String routeId)
    {
        return service.delete(routeId);
    }

    @GetMapping(value = "/all")
    public Set<RouteGuide> getAll()
    {
        return service.getAll();
    }
}