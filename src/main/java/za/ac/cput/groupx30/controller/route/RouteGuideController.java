package za.ac.cput.groupx30.controller.route;

/* Thaakir Ajouhaar - 217244394
 * RouteGuide Controller
 *  16 August 2021
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.factory.RouteGuideFactory;
import za.ac.cput.groupx30.service.route.RouteGuideService;

@RestController()
@RequestMapping("/routeGuide")
public class RouteGuideController
{
    @Autowired
    private RouteGuideService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public RouteGuide create(@RequestBody RouteGuide routeGuide)
    {
        RouteGuide newRouteGuide = RouteGuideFactory.createRouteGuide(routeGuide.getRouteId(), routeGuide.getGuideId());
        return service.create(newRouteGuide);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public RouteGuide read(@RequestBody RouteGuide routeGuide)
    {
        return service.read(routeGuide.getRouteId(), routeGuide.getGuideId());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody RouteGuide routeGuide)
    {
        return service.delete(routeGuide.getRouteId(), routeGuide.getGuideId());
    }
}
