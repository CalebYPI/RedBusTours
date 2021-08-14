package za.ac.cput.groupx30.repository.route.impl;

/*
 RouteRepositoryImpl.java
 Repository Implementation for the Route
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/

import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.repository.route.RouteRepository;

import java.util.HashSet;
import java.util.Set;

public class RouteRepositoryImpl implements RouteRepository {
    private static RouteRepositoryImpl repository = null;
    private Set<Route> routeDB;

    private RouteRepositoryImpl() {
        this.routeDB = new HashSet<>();
    }

    public static RouteRepositoryImpl getRepository() {
        if (repository == null)
            repository = new RouteRepositoryImpl();
        return repository;
    }

    @Override
    public Route create(Route route) {
        this.routeDB.add(route);
        return route;
    }

    @Override
    public Route read(String id) {
        for (Route route: routeDB) {
            if (route.getId().equalsIgnoreCase(id))
                return route;
        }
        return null;
    }

    @Override
    public Route update(Route route) {
        Route read = read(route.getId());
        if (read != null) {
            this.routeDB.remove(read);
            this.routeDB.add(route);
            return route;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Route route = read(id);
        if (route == null) {
            return false;
        }
        this.routeDB.remove(route);
        return true;
    }

    @Override
    public Set<Route> getAll() {
        return routeDB;
    }
}
