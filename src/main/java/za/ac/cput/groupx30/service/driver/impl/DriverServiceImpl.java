package za.ac.cput.groupx30.service.driver.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverServiceImpl Class
// Date: 02 August 2021

import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.repository.driver.DriverRepository;
import za.ac.cput.groupx30.repository.driver.impl.DriverRepositoryImpl;
import za.ac.cput.groupx30.service.driver.DriverService;

import java.util.HashSet;
import java.util.Set;

public class DriverServiceImpl implements DriverService {

    private static DriverService service = null;
    private DriverRepository repository;

    private DriverServiceImpl() {
        this.repository = DriverRepositoryImpl.getRepository();
    }

    public static DriverService getService() {
        if (service == null) service = new DriverServiceImpl();
        return service;
    }

    @Override
    public Set< Driver > getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set< Driver > getAllStartWithB() {
        Set<Driver> drivers = getAll();
        Set<Driver> driversWithB = new HashSet<>();
        for (Driver driver : drivers){
            if (driver.getName().trim().toLowerCase().startsWith("b")){
                driversWithB.add(driver);
            }
        }
        return driversWithB;
    }

    @Override
    public Driver create(Driver driver) {
        return this.repository.create(driver);
    }

    @Override
    public Driver read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Driver update(Driver driver) {
        return this.repository.update(driver);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
