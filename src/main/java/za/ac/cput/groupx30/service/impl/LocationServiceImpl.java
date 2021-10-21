package za.ac.cput.groupx30.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.factory.LocationFactory;
import za.ac.cput.groupx30.repository.LocationRepository;
import za.ac.cput.groupx30.service.LocationService;

import java.util.HashSet;
import java.util.Set;

@Service
public class LocationServiceImpl implements LocationService {
    private static LocationServiceImpl service = null;

    @Autowired
    private LocationRepository repository;

    public static LocationServiceImpl getService() {
        if (service == null)
            service = new LocationServiceImpl();
        return service;
    }

    @Override
    public Location create(Location location) {
        return this.repository.save(location);
    }

    @Override
    public Location read(String id) {
        return repository.getById(id);
    }

    @Override
    public Location update(Location location) {
        if (this.repository.existsById(location.getId()))
            return this.repository.save(location);
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }

    @Override
    public Set<Location> getAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
