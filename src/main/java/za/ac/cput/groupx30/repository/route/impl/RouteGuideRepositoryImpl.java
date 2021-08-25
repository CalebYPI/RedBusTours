/*package za.ac.cput.groupx30.repository.route.impl;

/*  RouteGuideRepositoryImpl.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 26 July 2021
 *

import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.repository.route.RouteGuideRepository;

import java.util.HashSet;
import java.util.Set;

public class RouteGuideRepositoryImpl implements RouteGuideRepository
{
    private static RouteGuideRepositoryImpl repository = null;
    private Set<RouteGuide> RouteGuideDB;

    private RouteGuideRepositoryImpl()
    {
        this.RouteGuideDB = new HashSet<>();
    }

    public static RouteGuideRepositoryImpl getRepository()
    {
        if (repository == null) repository = new RouteGuideRepositoryImpl();
        return repository;
    }

    @Override
    public RouteGuide create(RouteGuide routeGuide)
    {
        this.RouteGuideDB.add(routeGuide);
        return routeGuide;
    }

    @Override
    public RouteGuide read(String routeId, String guideId)
    {
        for(RouteGuide routeGuide: RouteGuideDB )
        {
            if (routeGuide.getRouteId().equalsIgnoreCase(routeId) && routeGuide.getGuideId().equalsIgnoreCase(guideId))
                return routeGuide;
        }
        return null;
    }

    @Override
    public boolean delete(String routeId, String guideId)
    {
        RouteGuide routeGuide = read(routeId,guideId);
        if (routeGuide != null)
        {
            this.RouteGuideDB.remove(routeId);
            this.RouteGuideDB.remove(guideId);
            return true;
        }
        return false;
    }


}
 */
