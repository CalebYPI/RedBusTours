package za.ac.cput.groupx30.repository.route.impl;

/*
 LocationRouteRepositoryImpl.java
 Repository Implementation for the LocationRoute
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/

import za.ac.cput.groupx30.entity.LocationRoute;
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
    public LocationRoute read(String locationId, String routeId) {
        for (LocationRoute locationRoute: locationRouteDB) {
            if (locationRoute.getLocationId().equalsIgnoreCase(locationId) && locationRoute.getRouteId().equalsIgnoreCase(routeId))
                return locationRoute;
        }
        return null;
    }

    @Override
    public boolean delete(String locationId, String routeId) {
        LocationRoute locationRoute = read(locationId, routeId);
        if (locationRoute != null) {
            this.locationRouteDB.remove(locationId);
            this.locationRouteDB.remove(routeId);
            return true;
        }
        return false;
    }
}
