package za.ac.cput.groupx30.service.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverVehicleServiceImpl Class
// Date: 02 August 2021

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.repository.DriverVehicleRepository;
import za.ac.cput.groupx30.service.DriverVehicleService;

import java.util.HashSet;
import java.util.Set;

@Service
public class DriverVehicleServiceImpl implements DriverVehicleService {

    private static DriverVehicleService service = null;
    @Autowired
    private DriverVehicleRepository repository;


    public static DriverVehicleService getService() {
        if (service == null) service = new DriverVehicleServiceImpl();
        return service;
    }

    @Override
    public Set< DriverVehicle > getAll() {
        return getAllStartWithM();
    }

    @Override
    public Set< DriverVehicle > getAllStartWithM() {
        Set<DriverVehicle> driverVehicles = getAll();
                Set<DriverVehicle> driverVehiclesWithM = new HashSet<>();
                for (DriverVehicle driverVehicle : driverVehicles){
                    if (driverVehicle.getVehicleId().trim().toLowerCase().startsWith("m")){
                        driverVehiclesWithM.add(driverVehicle);
                    }
                }
                return driverVehiclesWithM;
    }

    @Override
    public DriverVehicle create(DriverVehicle driverVehicle) {
        return this.repository.save(driverVehicle);
    }

    @Override
    public DriverVehicle read(DriverVehicle.DriverVehicleId vehicleId) {
        return this.repository.findById(vehicleId).orElse(null);
    }

    @Override
    public boolean delete(DriverVehicle driverVehicle) {
        if (driverVehicle != null){
            this.repository.delete(driverVehicle);
            return true;
        }
        return false;
    }

}
