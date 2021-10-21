package za.ac.cput.groupx30.service.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverServiceImpl Class
// Date: 02 August 2021

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.factory.DriverFactory;
import za.ac.cput.groupx30.repository.DriverRepository;
import za.ac.cput.groupx30.service.DriverService;

import java.util.HashSet;
import java.util.Set;

@Service
public class DriverServiceImpl implements DriverService {

    private static DriverService service = null;
    @Autowired
    private DriverRepository repository;


    public static DriverService getService() {
        if (service == null) service = new DriverServiceImpl();
        return service;
    }

    @Override
    public Set<Driver> getAll() {
        return new HashSet<>(this.repository.findAll());
    }

    @Override
    public Set<Driver> getAllStartWithB() {
        Set<Driver> drivers = getAll();
        Set<Driver> driversWithB = new HashSet<>();
        for (Driver driver : drivers) {
            if (driver.getName().trim().toLowerCase().startsWith("b")) {
                driversWithB.add(driver);
            }
        }
        return driversWithB;
    }

    @Override
    public Driver create(Driver driver) {
        Driver newDriver = DriverFactory.createId(driver.getName());
        return this.repository.save(newDriver);
    }

    @Override
    public Driver read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Driver update(Driver driver) {
        if (this.repository.existsById(driver.getId()))
            return this.repository.save(driver);
        return null;
    }

    @Override
    public boolean delete(String s) {
        if (s != null) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }
}
