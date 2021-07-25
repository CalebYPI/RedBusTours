package za.ac.cput.groupx30.repository.driverRoute.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Entity: DriverRouteRepositoryImpl
// Date: 26 July 2021

import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.repository.driverRoute.DriverRouteRepository;

import java.util.HashSet;
import java.util.Set;

    public class DriverRouteRepositoryImpl implements DriverRouteRepository {
        private static DriverRouteRepository repository = null;
        private Set< DriverRoute > driverRouteDB;

        private DriverRouteRepositoryImpl() { this.driverRouteDB = new HashSet<>();}

        public static DriverRouteRepository getRepository() {
            if (repository == null) repository = new za.ac.cput.groupx30.repository.driverRoute.impl.DriverRouteRepositoryImpl();
            return repository;
        }

        @Override
        public Set< DriverRoute > getAll() {
            return driverRouteDB;
        }

        @Override
        public DriverRoute create(DriverRoute driverRoute) {
            this.driverRouteDB.add(driverRoute);
            return driverRoute;
        }

        @Override
        public DriverRoute read(String routeID) {
            for (DriverRoute driverRoute: driverRouteDB) {
                if (driverRoute.getRouteID().equalsIgnoreCase(routeID))
                    return driverRoute;
            }
            return null;
        }

        @Override
        public DriverRoute update(DriverRoute driverRoute) {
            DriverRoute read = read(driverRoute.getRouteID());
            if (read != null) {
                this.driverRouteDB.remove(read);
                this.driverRouteDB.add(driverRoute);
                return driverRoute;
            }
            return null;
        }

        @Override
        public boolean delete(String routeID) {
            DriverRoute driverRoute = read(routeID);
            if (driverRoute != null) {
                this.driverRouteDB.remove(routeID);
                return true;
            }
            return false;
        }
    }
