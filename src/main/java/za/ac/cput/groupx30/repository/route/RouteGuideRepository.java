package za.ac.cput.groupx30.repository.route;

/*  RouteGuideRepository.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 26 July 2021
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.RouteGuide;

import java.util.List;

@Repository
public interface RouteGuideRepository extends JpaRepository<RouteGuide, String>
{

//    List<RouteGuide> findAllByGuideId(String guideId);
//    List<RouteGuide> findAllByRouteId(String routeId);
}