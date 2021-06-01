package za.ac.cput.groupx30.factory;
/*
 RouteFactory.java
 Factory for the Route
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.util.Helper;

public class RouteFactory {
    public static Route createRoute(String description, double distance, double time) {
        String id = Helper.generateId();
        double hours = time/60;
        if (description.isEmpty() || distance < 0 || time < 0)
            return null;
        Route route = new Route.Builder()
                .setId(id)
                .setDescription(description)
                .setDistance(distance)
                .setTime(hours)
                .build();
        return route;
    }
}
