package za.ac.cput.groupx30.service;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverService Interface
// Date: 02 August 2021

import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface DriverService extends IService<Driver, String> {
    Set<Driver> getAll();

    Set<Driver> getAllStartWithB();
}
