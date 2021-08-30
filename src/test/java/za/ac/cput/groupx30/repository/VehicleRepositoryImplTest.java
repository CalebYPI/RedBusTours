package za.ac.cput.groupx30.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.factory.VehicleFactory;
import za.ac.cput.groupx30.repository.impl.VehicleRepositoryImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class VehicleRepositoryImplTest {
    private VehicleRepository repository = VehicleRepositoryImpl.getRepository();
    private static Vehicle mercedes = VehicleFactory.createVehicle(Vehicle.getDesc(), "AMG GT");

    @Test
    void a_create() {
        Vehicle created = repository.create(mercedes);
        assertEquals(mercedes.getId(), created.getId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Vehicle read = repository.read(mercedes.Id);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Vehicle updated = new Vehicle.Builder().copy(mercedes).setDesc("SLR McLaren").build();
        updated = repository.update(updated);
        assertNotEquals(mercedes.getDesc(), updated.getDesc());
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean deleted = repository.delete(mercedes.Id);
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void d_getAll() {
        Set<Vehicle> vehicles = repository.getAll();
        assertEquals(1, vehicles.size());
        System.out.println("All Vehicles: " + vehicles);
    }
}