package za.ac.cput.groupx30.service.route.impl;

/* Thaakir Ajouhaar - 217244394
 * RouteGuideServiceimpl.java
 *  2 August 2021
 */

import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.repository.route.RouteGuideRepository;
import za.ac.cput.groupx30.repository.route.impl.RouteGuideRepositoryImpl;
import za.ac.cput.groupx30.service.route.RouteGuideService;

@Service
public class RouteGuideServiceImpl implements RouteGuideService
{
    private RouteGuideRepository repository = null;
    private static RouteGuideServiceImpl service = null;

    private RouteGuideServiceImpl()
    {
        this.repository = RouteGuideRepositoryImpl.getRepository();
    }

    public static RouteGuideServiceImpl getService()
    {
        if (service == null)
            service = new RouteGuideServiceImpl();
        return service;
    }

    @Override
    public RouteGuide create(RouteGuide routeGuide)
    {
        return this.repository.create(routeGuide);
    }

    @Override
    public RouteGuide read(String routeId, String guideId)
    {
        return this.repository.read(routeId, guideId);
    }

    @Override
    public boolean delete(String routeId, String guideId) {
        return false;
    }

}
