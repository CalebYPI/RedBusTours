package za.ac.cput.groupx30.service.route;

import za.ac.cput.groupx30.entity.LocationRoute;

public interface LocationRouteService {
    LocationRoute create(LocationRoute locationRoute);
    LocationRoute read(String locationId, String routeId);
    boolean delete(String locationId, String routeId);
}
