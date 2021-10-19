package za.ac.cput.groupx30.factory;
/*
 LocationRouteFactoryTest.java
 Test Factory for the LocationRoute
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class LocationRouteFactoryTest {

    private String locationId = Helper.generateId();
    private String routeId = Helper.generateId();

    @Test
    void createLocationRoute() {
        //Object Identity
        LocationRoute blueTableMountain = LocationRouteFactory.createLocationRoute(locationId, routeId);
        LocationRoute blueCopy = new LocationRoute.Builder().copy(blueTableMountain).build();
        System.out.println(blueTableMountain);
        assertSame(blueTableMountain.getLocationId(), blueCopy.getLocationId());
    }

    @Test
    void sameLocationRoute() {
        //Object Equality
        LocationRoute red = LocationRouteFactory.createLocationRoute(locationId, routeId);
        LocationRoute redCopy = new LocationRoute.Builder().copy(red).build();
        assertEquals(red.getRouteId(), redCopy.getRouteId());
    }

    @Test
    @Timeout(5)
    void timedOutLocationRoute() throws InterruptedException {
        //Timeout
        Thread.sleep(6000);
        createLocationRoute();
    }

    @Test
    @Disabled
    void disablingLocationRoute() {
        //Disabling Test
        LocationRoute YellowD6 = LocationRouteFactory.createLocationRoute(locationId, routeId);
        System.out.println(YellowD6);
    }
}