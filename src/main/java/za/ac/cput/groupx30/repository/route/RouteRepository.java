package za.ac.cput.groupx30.repository.route;

/*
 RouteRepository.java
 Repository for the Route
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/

import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface RouteRepository extends IRepository<Route, String> {
    Set<Route> getAll();
}
