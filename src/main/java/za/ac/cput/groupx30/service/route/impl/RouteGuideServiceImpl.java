package za.ac.cput.groupx30.service.route.impl;

/* Thaakir Ajouhaar - 217244394
 * RouteGuideServiceimpl.java
 *  2 August 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.repository.route.RouteGuideRepository;
import za.ac.cput.groupx30.service.route.RouteGuideService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RouteGuideServiceImpl implements RouteGuideService
{
    private static RouteGuideServiceImpl service = null;

    @Autowired
    private RouteGuideRepository repository;

    @Override
    public RouteGuide create(RouteGuide routeGuide)
    {
        return this.repository.save(routeGuide);
    }

    @Override
    public RouteGuide read(String id)
    {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public RouteGuide update(RouteGuide routeGuide)
    {
        if(this.repository.existsById(routeGuide.getRouteId()))
            return this.repository.save(routeGuide);
        return null;
    }

    @Override
    public boolean delete(String routeGuideId)
    {
        this.repository.deleteById(routeGuideId);
        if(this.repository.existsById(routeGuideId))
            return false;
        else
            return true;
    }

    @Override
    public Set<RouteGuide> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
