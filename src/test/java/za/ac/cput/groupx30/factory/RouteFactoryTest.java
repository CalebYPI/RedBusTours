package za.ac.cput.groupx30.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Route;

import static org.junit.jupiter.api.Assertions.*;

class RouteFactoryTest {

    @Test
    void createRoute() {
        Route blue = RouteFactory.createRoute("Wine Route", 25, 72);
        Route red = RouteFactory.createRoute("Peninsula Route", 15, -50);
        Route redAdjusted = new Route.Builder().setTime(56).build();
        System.out.println(blue);
        System.out.println(red);
        System.out.println(redAdjusted);
        assertNotEquals(red, redAdjusted);
    }
}