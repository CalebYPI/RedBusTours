package za.ac.cput.groupx30.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.repository.DriverRouteRepository;
import za.ac.cput.groupx30.service.DriverRouteService;

import java.util.HashSet;
import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */

@Service
public class DriverRouteServiceImp implements DriverRouteService {

    public static DriverRouteService service = null;
    @Autowired
    private DriverRouteRepository repository;


    public static DriverRouteService getService() {
        if (service == null) service = new DriverRouteServiceImp();
        return service;
    }


    @Override
    public DriverRoute create(DriverRoute driverRoute) {

        return this.repository.save(driverRoute);
    }

    @Override
    public DriverRoute read(DriverRoute.DriverRouteId id) {
        return this.repository.getById(id);
    }

    @Override
    public boolean delete(DriverRoute driverRouteId) {
        if (driverRouteId != null) {
            this.repository.delete(driverRouteId);
            return true;
        }
        return false;
    }

    @Override
    public Set<DriverRoute> getAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
