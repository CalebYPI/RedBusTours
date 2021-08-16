package za.ac.cput.groupx30.service.route;

import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface LocationRouteService extends IService<LocationRoute, String> {
    Set<LocationRoute> getAll();
}
