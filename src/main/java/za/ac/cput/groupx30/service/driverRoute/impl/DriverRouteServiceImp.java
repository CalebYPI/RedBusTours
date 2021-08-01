package za.ac.cput.groupx30.service.driverRoute.impl;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */

import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.repository.driverRoute.DriverRouteRepository;
import za.ac.cput.groupx30.repository.driverRoute.impl.DriverRouteImpl;
import za.ac.cput.groupx30.service.driverRoute.DriverRouteService;

import java.util.Set;

public class DriverRouteServiceImp implements DriverRouteService {

    private DriverRouteRepository repository;
    private static DriverRouteServiceImp service;

    private DriverRouteServiceImp() {
        this.repository = DriverRouteImpl.getRepository();
    }

    private static DriverRouteServiceImp getService(){
        if (service == null)
            service = new DriverRouteServiceImp();
        return service;
    }


    @Override
    public DriverRoute create(DriverRoute driverRoute) {
        return repository.create(driverRoute);
    }

    @Override
    public DriverRoute read(String driverRouteID) {
        return this.repository.read(driverRouteID);
    }

    @Override
    public DriverRoute update(DriverRoute driverRoute) {
        return this.repository.update(driverRoute);
    }

    @Override
    public boolean delete(String driverRouteID) {
        return this.repository.delete(driverRouteID);
    }

    @Override
    public Set<DriverRoute> getAll() {
        return this.repository.getAll();
    }
}
