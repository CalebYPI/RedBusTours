package za.ac.cput.groupx30.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class LocationRouteFactoryTest {

    private String locationId = Helper.generateId();
    private String routeId = Helper.generateId();

    @Test
    void createLocationRoute() {
        LocationRoute blueTableMountain = LocationRouteFactory.createLocationRoute(locationId, routeId);
        System.out.println(blueTableMountain);
        assertTrue(blueTableMountain instanceof LocationRoute);
    }
}