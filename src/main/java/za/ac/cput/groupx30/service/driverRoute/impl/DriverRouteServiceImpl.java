package za.ac.cput.groupx30.service.driverRoute.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverRouteServiceImpl Class
// Date: 02 August 2021

import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.repository.driverRoute.DriverRouteRepository;
import za.ac.cput.groupx30.repository.driverRoute.impl.DriverRouteRepositoryImpl;
import za.ac.cput.groupx30.service.driverRoute.DriverRouteService;

import java.util.Set;

public class DriverRouteServiceImpl implements DriverRouteService {

    private static DriverRouteService service = null;
        private DriverRouteRepository repository;

        private DriverRouteServiceImpl() {
            this.repository = DriverRouteRepositoryImpl.getRepository();
        }

        public static DriverRouteService getService() {
            if (service == null) service = new DriverRouteServiceImpl();
            return service;
        }

    @Override
    public Set< DriverRoute > getAll() {
        return this.repository.getAll();
    }

    @Override
    public DriverRoute create(DriverRoute driverRoute) {
        return this.repository.create(driverRoute);
    }

    @Override
    public DriverRoute read(String s) {
        return this.repository.read(s);
    }

    @Override
    public DriverRoute update(DriverRoute driverRoute) {
        return this.repository.update(driverRoute);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
