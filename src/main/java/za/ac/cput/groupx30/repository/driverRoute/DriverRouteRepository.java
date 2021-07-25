package za.ac.cput.groupx30.repository.driverRoute;

/**
 * Baron Mukenyi (217163742)
 * Class repository for Driver Route
 * 25 July 2021
 */

import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface DriverRouteRepository extends IRepository<DriverRoute, String> {
    public Set<DriverRoute> getAll();
}
