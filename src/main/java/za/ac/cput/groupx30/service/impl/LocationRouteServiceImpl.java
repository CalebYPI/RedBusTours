package za.ac.cput.groupx30.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.repository.LocationRouteRepository;
import za.ac.cput.groupx30.service.LocationRouteService;

import java.util.HashSet;
import java.util.Set;

@Service
public class LocationRouteServiceImpl implements LocationRouteService {
    private static LocationRouteServiceImpl service = null;

    @Autowired
    private LocationRouteRepository repository;


    public static LocationRouteServiceImpl getService() {
        if (service == null)
            service = new LocationRouteServiceImpl();
        return service;
    }

    @Override
    public LocationRoute save(LocationRoute locationRoute) {
        return this.repository.save(locationRoute);
    }

    @Override
    public LocationRoute read(LocationRoute.LocationRouteId id) {
        return this.repository.getById(id);
    }

    @Override
    public Set<LocationRoute> getAll() {
        return new HashSet<>(this.repository.findAll());
    }

    @Override
    public boolean delete(LocationRoute locationRoute) {
        if (locationRoute!= null) {
            this.repository.delete(locationRoute);
            return true;
        }
        return false;
    }

    @Override
    public Set<LocationRoute> findAllByLocationId(String locationId) {
        Set<LocationRoute> locations = getAll();
        if (locations != null) {
        locations.removeIf(locationRoute -> !locationRoute.getLocationId().equalsIgnoreCase(locationId));
        return locations;
        }
        return null;
    }

    @Override
    public Set<LocationRoute> findAllByRouteId(String routeId) {
        Set<LocationRoute> routes = getAll();
        if (routes != null) {
            routes.removeIf(locationRoute -> locationRoute.getRouteId().equalsIgnoreCase(routeId));
            return routes;
        }
        return null;
    }
}
