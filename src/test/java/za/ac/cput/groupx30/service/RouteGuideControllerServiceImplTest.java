package za.ac.cput.groupx30.service;

/*  RouteGuideServiceImplTest.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 02 August 2021
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.factory.GuideFactory;
import za.ac.cput.groupx30.factory.RouteGuideFactory;
import za.ac.cput.groupx30.service.route.RouteGuideService;
import za.ac.cput.groupx30.service.route.impl.RouteGuideServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class RouteGuideControllerServiceImplTest
{

    private static RouteGuideService service = RouteGuideServiceImpl.getService();
    private static RouteGuide no1 = RouteGuideFactory.createRouteGuide("698293", "Sir Lowreys Pass");
    private static Guide no2 = GuideFactory.createId("Jacob Kobly", "9812195081087");
    private static RouteGuide routeGuide = RouteGuideFactory.createRouteGuide(no1.getRouteId(), no2.getId());

    @Test
    void create()
    {
        RouteGuide create = service.create(routeGuide);
        assertEquals(routeGuide.getRouteId(),create.getRouteId());
        assertEquals(routeGuide.getGuideId(),create.getGuideId());
        System.out.println("Created : " + create);
    }

    @Test
    void read()
    {
        RouteGuide read = service.read(no1.getRouteId(), no2.getId());
        assertNotNull(read);
        System.out.println("Read : " + read);
    }

    @Test
    void delete()
    {
        boolean delete = service.delete(no1.getRouteId(), no2.getId());
        assertTrue(delete);
        System.out.println("Deleted : " + delete);
    }
}
