package za.ac.cput.groupx30.service.route;

import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface LocationRouteService  {
    LocationRoute save(LocationRoute locationRoute);
    LocationRoute read(LocationRoute.LocationRouteId id);
    Set<LocationRoute> getAll();
    boolean delete(LocationRoute locationRoute);
}
