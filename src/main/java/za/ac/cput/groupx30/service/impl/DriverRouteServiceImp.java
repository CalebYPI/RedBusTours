package za.ac.cput.groupx30.service.impl;



import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.repository.DriverRouteRepository;
import za.ac.cput.groupx30.repository.impl.DriverRouteRepositoryImpl;
import za.ac.cput.groupx30.service.DriverRouteService;

import java.util.Set;

/**
 * Baron Mukenyi (217163742)
 * Class for driver route service
 * 29 July 2021
 */

@Service
public class DriverRouteServiceImp implements DriverRouteService {

    public static DriverRouteService service = null;
    private DriverRouteRepository repository;

    private DriverRouteServiceImp(){this.repository = DriverRouteRepositoryImpl.getRepository();}

    public static DriverRouteService getService(){
        if(service == null) service = new DriverRouteServiceImp();
        return service;
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

    @Override
    public Set<DriverRoute> getAll() {
        return getAll();
    }
}
