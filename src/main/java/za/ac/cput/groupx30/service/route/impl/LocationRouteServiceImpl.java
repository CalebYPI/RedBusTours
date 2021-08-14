package za.ac.cput.groupx30.service.route.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.repository.route.LocationRouteRepository;
import za.ac.cput.groupx30.repository.route.impl.LocationRouteRepositoryImpl;
import za.ac.cput.groupx30.service.route.LocationRouteService;

@Service
public class LocationRouteServiceImpl implements LocationRouteService {
    private LocationRouteRepository repository = null;
    private static LocationRouteServiceImpl service = null;

    private LocationRouteServiceImpl() {
        this.repository = LocationRouteRepositoryImpl.getRepository();
    }

    public static LocationRouteServiceImpl getService() {
        if (service == null)
            service = new LocationRouteServiceImpl();
        return service;
    }

    @Override
    public LocationRoute create(LocationRoute locationRoute) {
        return this.repository.create(locationRoute);
    }

    @Override
    public LocationRoute read(String locationId, String routeId) {
        return this.repository.read(locationId, routeId);
    }

    @Override
    public boolean delete(String locationId, String routeId) {
        return this.repository.delete(locationId, routeId);
    }
}
