package za.ac.cput.groupx30.factory;

/**
 * Baron Mukenyi (217163742)
 * Class repository for Driver Route
 * 25 July 2021
 */

import za.ac.cput.groupx30.entity.DriverRoute;

public class DriverRouteFactory {
    public static DriverRoute createRoute(String driverID, String routeID){


        DriverRoute driverRoute = new DriverRoute.Builder().setRouteID(routeID).setDriverID(driverID).build();
        return driverRoute;
    }
}
