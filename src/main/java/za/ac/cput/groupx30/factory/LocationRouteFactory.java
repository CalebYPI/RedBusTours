package za.ac.cput.groupx30.factory;
/*
 LocationRoute.java
 Factory for the LocationRoute
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

import za.ac.cput.groupx30.entity.LocationRoute;

public class LocationRouteFactory {
    public static LocationRoute createLocationRoute(String locationId, String routeId) {
        if (locationId.isEmpty() ||  routeId.isEmpty())
            return new LocationRoute.Builder().build();
        LocationRoute locationRoute = new LocationRoute.Builder()
                .setLocationId(locationId)
                .setRouteId(routeId)
                .build();
        return locationRoute;
    }
}
