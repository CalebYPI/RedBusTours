package za.ac.cput.groupx30.service;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Test cases for PassengerService
 * Date: 31 July 2021
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.factory.PassengerFactory;
import za.ac.cput.groupx30.service.impl.PassengerServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class PassengerServiceImplTest {

    private static PassengerService service = PassengerServiceImpl.getService();
    private static Passenger passenger = PassengerFactory.createPassenger("Shaheed", "0787092205");
    @Test
    void a_create() {
        Passenger created = service.create(passenger);
        assertEquals(created.getId(), passenger.getId());
        System.out.println("Create: " + created + "\nCreate: " + created);
    }

    @Test
    void b_read() {
        Passenger read = service.read(passenger.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Passenger updated = new Passenger.Builder().copy(passenger).setName("David").setContact("0784512399").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(passenger.getId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(service.getAll());
    }
}