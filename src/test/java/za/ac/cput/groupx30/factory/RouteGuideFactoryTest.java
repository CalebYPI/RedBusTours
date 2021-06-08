package za.ac.cput.groupx30.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.RouteGuide;

import static org.junit.jupiter.api.Assertions.*;

class RouteGuideFactoryTest {

    @Test
    void createRouteGuide()
    {
        RouteGuide routeGuide1 = RouteGuideFactory.createRouteGuide("324334", "Table Mountain Guide");
        RouteGuide routeGuide2 = new RouteGuide.Builder().copy(routeGuide1).setGuideId("Chapmans Peak Guide").build();
        System.out.print(routeGuide1);
        System.out.println(routeGuide2);
        assertNotSame(routeGuide1, routeGuide2);
    }

}