package za.ac.cput.groupx30.service.route.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.repository.route.LocationRouteRepository;
import za.ac.cput.groupx30.service.route.LocationRouteService;

import java.util.HashSet;
import java.util.Set;

@Service
public class LocationRouteServiceImpl implements LocationRouteService {
    private static LocationRouteServiceImpl service = null;

    //@Autowired
    private LocationRouteRepository repository;
    @Autowired
    public static LocationRouteServiceImpl getService() {
        if (service == null)
            service = new LocationRouteServiceImpl();
        return service;
    }

    @Override
    public LocationRoute create(LocationRoute locationRoute) {
        return this.repository.save(locationRoute);
    }

    @Override
    public LocationRoute read(String id) {
        return this.repository.getById(id);
    }

    @Override
    public LocationRoute update(LocationRoute locationRoute) {
        if (this.repository.existsById(locationRoute.getLocationId()))
            return this.repository.save(locationRoute);
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }

    @Override
    public Set<LocationRoute> getAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
