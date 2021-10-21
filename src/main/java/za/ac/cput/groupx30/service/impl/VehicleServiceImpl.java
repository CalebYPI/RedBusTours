package za.ac.cput.groupx30.service.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Service: VehicleServiceImpl Class
// Date: 02 August 2021

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.factory.VehicleFactory;
import za.ac.cput.groupx30.repository.VehicleRepository;
import za.ac.cput.groupx30.service.VehicleService;

import java.util.HashSet;
import java.util.Set;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository repository;
    private static VehicleServiceImpl service;

    public static VehicleServiceImpl getService() {
        if (service == null)
            service = new VehicleServiceImpl();
        return service;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return this.repository.save(vehicle);
    }

    @Override
    public Vehicle read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        if (this.repository.existsById(vehicle.getId())) {
            return this.repository.save(vehicle);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }

    @Override
    public Set<Vehicle> getAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
