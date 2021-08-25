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

@Service
public class RouteGuideServiceImpl implements RouteGuideService
{
    private static RouteGuideServiceImpl service = null;

    private RouteGuideRepository repository;
    @Autowired
    public static RouteGuideServiceImpl getService()
    {
        if (service == null)
            service = new RouteGuideServiceImpl();
        return service;
    }

    @Override
    public RouteGuide create(RouteGuide routeGuide)
    {
        return this.repository.save(routeGuide);
    }

    @Override
    public RouteGuide read(RouteGuide.RouteGuideId id)
    {
        return this.repository.getById(id);
    }

    @Override
    public boolean delete(RouteGuide routeGuide)
    {
        this.repository.delete(routeGuide);
        return true;
    }

    @Override
    public Set<RouteGuide> getAll()
    {
        return new HashSet<>(this.repository.findAll());
    }


}
