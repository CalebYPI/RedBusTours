package za.ac.cput.groupx30.factory;

/* Thaakir Ajouhaar - 217244394
 * RouteGuide Factory
 *  7 June 2021
 */

import za.ac.cput.groupx30.entity.RouteGuide;

public class RouteGuideFactory {

    public static RouteGuide createRouteGuide(String routeId, String guideId) {

        RouteGuide routeGuide = new RouteGuide.Builder()
                .setRouteId(routeId)
                .setGuideId(guideId)
                .build();

        return routeGuide;
    }
}
