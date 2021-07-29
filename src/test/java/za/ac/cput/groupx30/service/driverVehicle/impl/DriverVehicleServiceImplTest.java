package za.ac.cput.groupx30.service.driverVehicle.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Service: DriverVehicleServiceImpl Test
// Date: 02 August 2021

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.factory.DriverVehicleFactory;
import za.ac.cput.groupx30.service.driverVehicle.DriverVehicleService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DriverVehicleServiceImplTest {

    private static DriverVehicleService service = DriverVehicleServiceImpl.getService();
    private static DriverVehicle driverVehicle = DriverVehicleFactory.createDriverVehicle("Mercedes Benz - Bus15");


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
    void read() {
        DriverVehicle read = service.read(driverVehicle.getVehicleId());
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
    void delete() {
         boolean deleted = service.delete(driverVehicle.getVehicleId());
         assertTrue(deleted);
    }
}