package za.ac.cput.groupx30.repository;


/**
 * Baron Mukenyi (217163742)
 * Class repository for Driver Route
 * 25 July 2021
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

@Repository
public interface DriverRouteRepository extends JpaRepository<DriverRoute, DriverRoute.DriverRouteId> {
    //Set<DriverRoute> getAll();
}
