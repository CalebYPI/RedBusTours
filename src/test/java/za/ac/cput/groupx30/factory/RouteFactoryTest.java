package za.ac.cput.groupx30.factory;
/*
 RouteFactoryTest.java
 Test Factory for the Route
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

import org.junit.jupiter.api.*;
import za.ac.cput.groupx30.entity.Route;

import static org.junit.jupiter.api.Assertions.*;

class RouteFactoryTest {

    @Test
    void createRoute() {
        //Object Identity
        Route blue = RouteFactory.createRoute("Wine Route", 25, 72);
        Route red = RouteFactory.createRoute("Peninsula Route", 15, -50);
        Route redAdjusted = new Route.Builder().setTime(56).build();
        System.out.println(blue);
        System.out.println(red);
        System.out.println(redAdjusted);
        assertSame(red.getId(), redAdjusted.getId());
    }

    @Test
    void sameRoute() {
        //Object Equality
        Route boat1 = RouteFactory.createRoute("WaterFront", 20, 45);
        Route boat2 = new Route.Builder().copy(boat1).setTime(55).build();
        assertEquals(boat1.getDescription(), boat2.getDescription());
    }

    @Test
    @Timeout(5)
    void timedOutRoute() throws InterruptedException {
        Thread.sleep(6000);
        createRoute();
    }

    @Test
    @Disabled
    void disablingRoute() {
        //Disabling Test
        Route yellow = RouteFactory.createRoute("Township Route", 10, -50);
        System.out.println(yellow);
    }
}