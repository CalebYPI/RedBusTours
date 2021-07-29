package za.ac.cput.groupx30.repository.driverVehicle.impl;

// Author: Thokozile Snono
// Student number: 216032121
// Entity: DriverVehicleRepositoryImpl Test
// Date: 26 July 2021

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.factory.DriverVehicleFactory;
import za.ac.cput.groupx30.repository.driverVehicle.DriverVehicleRepository;

import static org.junit.jupiter.api.Assertions.*;

class DriverVehicleRepositoryImplTest {
    private static DriverVehicleRepository repository = DriverVehicleRepositoryImpl.getRepository();
    private static DriverVehicle driverVehicle = DriverVehicleFactory.createDriverVehicle("Mercedes Benz - Bus15");

    @Test
    public void a_create(){
        DriverVehicle created = repository.create(driverVehicle);
        assertEquals(driverVehicle.getVehicleId(), created.getVehicleId());
        assertEquals(driverVehicle.getDriverId(), created.getDriverId());
        System.out.println("CreatedRoom: " + created);
    }

    @Test
    public void b_read(){
        DriverVehicle read = repository.read(driverVehicle.getVehicleId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        DriverVehicle updated = new DriverVehicle.Builder().copy(driverVehicle).setVehicleId("Mercedes Benz - Bus15 2020 Model").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        boolean deleted = repository.delete(driverVehicle.getVehicleId());
        assertTrue(deleted);
        System.out.println("Successfully deleted!");
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }
}