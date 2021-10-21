package za.ac.cput.groupx30.service;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverVehicleServiceImpl Test
// Date: 02 August 2021

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.factory.DriverFactory;
import za.ac.cput.groupx30.factory.DriverVehicleFactory;
import za.ac.cput.groupx30.factory.VehicleFactory;
import za.ac.cput.groupx30.service.impl.DriverVehicleServiceImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DriverVehicleServiceImplTest {

    private static DriverVehicleService service = DriverVehicleServiceImpl.getService();
    private static Driver driver = DriverFactory.createId("Sam");
    private static Vehicle vehicle = VehicleFactory.createVehicle("Bus15");
    private static DriverVehicle driverVehicle = DriverVehicleFactory.createDriverVehicle(driver.getId(), vehicle.getId());


    @Test
    void getAll() {
        Set<DriverVehicle> driverVehicle = service.getAll();
        assertEquals(1, driverVehicle.size());
        System.out.println("All driverVehicles: " + driverVehicle);
    }

    @Test
    void getAllStartWithM() {
    }

    @Test
    void create() {
        DriverVehicle created;
        created = service.create(driverVehicle);
        assertEquals(driverVehicle.getVehicleId(), created.getVehicleId());
        assertEquals(driverVehicle.getDriverId(), created.getVehicleId());
        System.out.println("Created: " + created);
    }

    @Test
    @Disabled
    void read() {
        DriverVehicle.DriverVehicleId id = new DriverVehicle.DriverVehicleId(driver.getId(), vehicle.getId());
        DriverVehicle read = service.read(id);
        System.out.println("Read:" + read);
    }

    @Test
    void update() {
        DriverVehicle.Builder builder = new DriverVehicle.Builder();
        builder.copy(driverVehicle);
        builder.setVehicleId("Mercedes Benz - Bus15");
        builder.setDriverId("6574");
        DriverVehicle update = builder.build();
        System.out.println("Updated: " + update);
    }

    @Test
    @Disabled
    void delete() {
        boolean deleted = service.delete(driverVehicle);
        assertTrue(deleted);
    }
}