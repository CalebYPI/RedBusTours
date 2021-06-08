package za.ac.cput.groupx30.factory;

import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.util.Helper;

public class DriverRouteFactory {
    public static DriverRoute createRoute(String routeID){
        String driverRouteID = Helper.generateId();

        DriverRoute driverRoute = new DriverRoute.Builder().setRouteID(routeID).setDriverID(driverRouteID).build();
        return driverRoute;
    }
}
