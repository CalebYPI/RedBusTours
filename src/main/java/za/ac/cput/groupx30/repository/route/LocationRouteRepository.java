package za.ac.cput.groupx30.repository.route;

/*
 LocationRouteRepository.java
 Repository for the LocationRoute
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/

import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface LocationRouteRepository extends IRepository<LocationRoute, String>{
    Set<LocationRoute> getAll();
}
