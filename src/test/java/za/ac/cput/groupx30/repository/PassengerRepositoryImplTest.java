//package za.ac.cput.groupx30.repository;
//
///**
// * Author: Shaheed_Cloete(213239442)
// * Desc: Test cases for PassengerRepository
// * Date: 24 July 2021
// */
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.groupx30.entity.Passenger;
//import za.ac.cput.groupx30.factory.PassengerFactory;
//import za.ac.cput.groupx30.repository.impl.PassengerRepositoryImpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrderer.MethodName.class)
//public class PassengerRepositoryImplTest {
//    private static PassengerRepositoryImpl repository = PassengerRepositoryImpl.getRepository();
//    private static Passenger passenger = PassengerFactory.createPassenger("Shaheed", "0787092205");
//    private static Passenger passenger2 = PassengerFactory.createPassenger("Robert", "0787547693");
//
//    @Test
//    void a_create() {
//        Passenger created = repository.create(passenger);
//        Passenger created2 = repository.create(passenger2);
//        assertEquals(created.getId(), passenger.getId());
//        assertEquals(created2.getId(), passenger2.getId());
//        System.out.println("Create: " + created + "\nCreate: " + created2);
//    }
//
//    @Test
//    void b_read() {
//        Passenger read = repository.read(passenger.getId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_update() {
//        Passenger updated = new Passenger.Builder().copy(passenger).setName("David").setContact("0784512399").build();
//        assertNotNull(repository.update(updated));
//        System.out.println("Update: " + updated);
//    }
//
//    @Test
//    void e_delete() {
//        boolean success = repository.delete(passenger.getId());
//        assertTrue(success);
//        System.out.println("Delete: " + success);
//    }
//
//    @Test
//    void d_getAll() {
//        System.out.println("Show all: ");
//        System.out.println(repository.getAll());
//    }
//}