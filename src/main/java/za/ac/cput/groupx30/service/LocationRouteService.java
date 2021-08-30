package za.ac.cput.groupx30.service;

import za.ac.cput.groupx30.entity.LocationRoute;

import java.util.Set;

public interface LocationRouteService {
    LocationRoute save(LocationRoute locationRoute);
    LocationRoute read(LocationRoute.LocationRouteId id);
    Set<LocationRoute> getAll();
    boolean delete(LocationRoute locationRoute);
    Set<LocationRoute> findAllByLocationId(String locationId);
    Set<LocationRoute> findAllByRouteId(String RouteId);
}
