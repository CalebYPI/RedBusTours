package za.ac.cput.groupx30.service.route;

/* Thaakir Ajouhaar - 217244394
 * RouteGuideService.java
 *  02 August 2021
 */

import za.ac.cput.groupx30.entity.RouteGuide;

public interface RouteGuideService
{
    RouteGuide create(RouteGuide routeGuide);
    RouteGuide read(String routeId, String guideId);
    boolean delete(String routeId, String guideId);
}
