package za.ac.cput.groupx30.repository.route;

import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface RouteRepository extends IRepository<Route, String> {
    Set<Route> getAll();
}
