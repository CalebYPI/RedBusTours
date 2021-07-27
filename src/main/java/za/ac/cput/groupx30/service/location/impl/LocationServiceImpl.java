package za.ac.cput.groupx30.service.location.impl;

import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.repository.location.LocationRepository;
import za.ac.cput.groupx30.repository.location.impl.LocationRepositoryImpl;
import za.ac.cput.groupx30.repository.route.RouteRepository;
import za.ac.cput.groupx30.repository.route.impl.RouteRepositoryImpl;
import za.ac.cput.groupx30.service.location.LocationService;
import za.ac.cput.groupx30.service.route.impl.RouteServiceImpl;

import java.util.Set;

public class LocationServiceImpl implements LocationService {

    private LocationRepository repository = null;
    private static LocationServiceImpl service = null;

    private LocationServiceImpl() {
        this.repository = LocationRepositoryImpl.getRepository();
    }

    public static LocationServiceImpl getService() {
        if (service == null)
            service = new LocationServiceImpl();
        return service;
    }

    @Override
    public Location create(Location location) {
        return this.repository.create(location);
    }

    @Override
    public Location read(String id) {
        return repository.read(id);
    }

    @Override
    public Location update(Location location) {
        return this.repository.update(location);
    }

    @Override
    public boolean delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Set<Location> getAll() {
        return this.repository.getAll();
    }
}
