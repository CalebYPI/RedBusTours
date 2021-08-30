package za.ac.cput.groupx30.service;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverServiceImpl Test
// Date: 02 August 2021

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.factory.DriverFactory;
import za.ac.cput.groupx30.service.DriverService;
import za.ac.cput.groupx30.service.impl.DriverServiceImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DriverServiceImplTest {

    private static DriverService service = DriverServiceImpl.getService();
    private static Driver driver = DriverFactory.createId("Ms Snono");

    @Test
    void getAll() {
        Set<Driver> drivers = service.getAll();
        assertEquals(1, drivers.size());
        System.out.println("All drivers: " + drivers);
    }

    @Test
    void getAllStartWithB() {
    }

    @Test
    void create() {
        Driver created;
        created = service.create(driver);
        assertEquals(driver.getId(), created.getId());
        assertEquals(driver.getName(), created.getName());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        Driver read = service.read(driver.getId());
        System.out.println("Read:" + read);
    }

    @Test
    void update() {
        Driver.Builder builder = new Driver.Builder();
        builder.copy(driver);
        builder.setId("Ms Snono");
        builder.setName("Ms Snono");
        Driver update = builder.build();
        System.out.println("Updated: " + update);
    }

    @Test
    void delete() {
        boolean deleted = service.delete(driver.getId());
        assertTrue(deleted);
    }
}