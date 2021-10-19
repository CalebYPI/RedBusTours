package za.ac.cput.groupx30.repository;

/*
 LocationRouteRepository.java
 Repository for the LocationRoute
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.List;
import java.util.Set;

@Repository
public interface LocationRouteRepository extends JpaRepository<LocationRoute, LocationRoute.LocationRouteId> {
}
