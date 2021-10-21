package za.ac.cput.groupx30.service;

// Author: Thokozile Snono
// Student number: 216032121
// Service: VehicleServiceImpl Test
// Date: 02 August 2021

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.factory.VehicleFactory;
import za.ac.cput.groupx30.service.impl.VehicleServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class VehicleServiceImplTest {

    private VehicleService service = VehicleServiceImpl.getService();
    private static Vehicle bus = VehicleFactory.createVehicle("Double Decker Bus");

    @Test
    void a_create() {
        Vehicle created = service.create(bus);
        assertEquals(created.Id, bus.Id);
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Vehicle read = service.read(bus.Id);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Vehicle update = new Vehicle.Builder().copy(bus).setDesc("Single Story Bus").build();
        update = service.update(update);
        assertEquals(update.Id, bus.Id);
        System.out.println("Updated: " + update);
    }

    @Test
    void e_delete() {
        boolean delete = service.delete(bus.Id);
        assertTrue(delete);
        System.out.println("Deleted: " + delete);
    }

    @Test
    void d_getAll() {
        assertEquals(1, service.getAll().size());
        System.out.println("All Vehicles: " + service.getAll());
    }
}