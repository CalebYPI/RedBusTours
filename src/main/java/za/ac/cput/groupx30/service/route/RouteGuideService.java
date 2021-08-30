package za.ac.cput.groupx30.service.route;

/* Thaakir Ajouhaar - 217244394
 * RouteGuideService.java
 *  02 August 2021
 */

import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface RouteGuideService extends IService<RouteGuide, String>
{
        public Set<RouteGuide> getAll();
}
