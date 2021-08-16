package za.ac.cput.groupx30.repository.driverRoute.impl;
/**
 * Baron Mukenyi (217163742)
 * Class repository for Driver Route
 * 25 July 2021
 */

import za.ac.cput.groupx30.entity.DriverRoute;
import za.ac.cput.groupx30.repository.driverRoute.DriverRouteRepository;

import java.util.HashSet;
import java.util.Set;

public class DriverRouteImpl implements DriverRouteRepository {
    public static DriverRouteImpl repository = null;
    private Set<DriverRoute> driverRouteDB;

    private DriverRouteImpl(){
        driverRouteDB = new HashSet<>();
    }

    public static DriverRouteImpl getRepository(){
        if(repository == null)
            repository = new DriverRouteImpl();
            return repository;
    }
    @Override
    public DriverRoute create(DriverRoute driverRoute) {
        boolean createRoute = driverRouteDB.add(driverRoute);
        if(!createRoute){
            return null;
        }
        return driverRoute;
    }

    @Override
    public DriverRoute read(String driverRouteID) {
        for(DriverRoute dR : driverRouteDB){
           if(dR.getDriverID().equals(driverRouteID)){
               return dR;
           }
        }
        return null;
    }

    @Override
    public DriverRoute update(DriverRoute driverRoute) {
        DriverRoute previousDriverRoute = read(driverRoute.getRouteID());
        if(previousDriverRoute != null){
            driverRouteDB.remove(previousDriverRoute);
            driverRouteDB.add(driverRoute);
            return driverRoute;
        }
        return null;
    }

    @Override
    public boolean delete(String driverRouteID) {
        DriverRoute removeDriverRoute = read(driverRouteID);
        if(removeDriverRoute == null){
            return false;
        }
        return true;
    }

    @Override
    public Set<DriverRoute> getAll() {
        return driverRouteDB;
    }
}
