package za.ac.cput.groupx30.repository.route.impl;

/*
 LocationRouteRepositoryImpl.java
 Repository Implementation for the LocationRoute
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/

import za.ac.cput.groupx30.entity.LocationRoute;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.repository.route.LocationRouteRepository;

import java.util.HashSet;
import java.util.Set;

public class LocationRouteRepositoryImpl implements LocationRouteRepository {
    private static LocationRouteRepositoryImpl repository = null;
    private Set<LocationRoute> locationRouteDB;

    private LocationRouteRepositoryImpl() {
        this.locationRouteDB = new HashSet<>();
    }

    public static LocationRouteRepositoryImpl getRepository() {
        if (repository == null) repository = new LocationRouteRepositoryImpl();
        return repository;
    }


    @Override
    public LocationRoute create(LocationRoute locationRoute) {
        this.locationRouteDB.add(locationRoute);
        return locationRoute;
    }

    @Override
    public LocationRoute read(String routeId) {
        LocationRoute locationRoute = locationRouteDB.stream()
                .filter(e -> e.getRouteId().equals(routeId))
                .findAny()
                .orElse(null);
        return locationRoute;
    }

    @Override
    public LocationRoute update(LocationRoute locationRoute) {
        LocationRoute oldLocationRoute = read(locationRoute.getRouteId());
        if (oldLocationRoute != null) {
            this.locationRouteDB.remove(oldLocationRoute);
            this.locationRouteDB.add(locationRoute);
            return locationRoute;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        LocationRoute locationRoute = read(id);
        if (locationRoute == null) {
            return false;
        }
        this.locationRouteDB.remove(locationRoute);
        return true;
    }

    @Override
    public Set<LocationRoute> getAll() {
        return locationRouteDB;
    }
}
