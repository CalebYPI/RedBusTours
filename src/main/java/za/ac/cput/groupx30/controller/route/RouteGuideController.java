package za.ac.cput.groupx30.controller.route;

/* Thaakir Ajouhaar - 217244394
 * RouteGuide Controller
 *  16 August 2021
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.factory.LocationRouteFactory;
import za.ac.cput.groupx30.factory.RouteGuideFactory;
import za.ac.cput.groupx30.service.route.RouteGuideService;

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

    @GetMapping(value = "/read/{routeId}/{guideId}")
    public RouteGuide read(@PathVariable String routeId, @PathVariable("guideId") String guideId)
    {
        RouteGuide.RouteGuideId id = new RouteGuide.RouteGuideId(routeId, guideId);
        return service.read(id);
    }

    @DeleteMapping(value = "/delete/{routeId}/{guideId}")
    public boolean delete(@PathVariable String routeId, @PathVariable("guideId") String guideId)
    {
        RouteGuide routeGuide = RouteGuideFactory.createRouteGuide(routeId, guideId);
        return service.delete(routeGuide);
    }

    @GetMapping(value = "/all")
    public Set<RouteGuide> getAll()
    {
        return service.getAll();
    }
}
