package za.ac.cput.groupx30.repository.route;

/*  RouteGuideRepository.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 26 July 2021
 */


import za.ac.cput.groupx30.entity.RouteGuide;

public interface RouteGuideRepository
{
    RouteGuide create(RouteGuide routeGuide);
    RouteGuide read(String routeId, String guideId);
    boolean delete(String routeId, String guideId);
}