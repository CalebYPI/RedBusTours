//package za.ac.cput.groupx30.service;
//
///**
// * Author: Shaheed_Cloete(213239442)
// * Desc: Test cases for PassengerTicketService
// * Date: 31 July 2021
// */
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.groupx30.entity.PassengerTicket;
//import za.ac.cput.groupx30.factory.PassengerTicketFactory;
//import za.ac.cput.groupx30.service.impl.PassengerTicketServiceImpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class PassengerTicketServiceImplTest {
//
//    private static PassengerTicketService service = PassengerTicketServiceImpl.getService();
//    PassengerTicket passengerticket = PassengerTicketFactory.createPassengerTicket("01","74ff9b7f-3ac5-464a-a8e1-c02bf40bb2ab");
//
//    @Test
//    void a_create() {
//        PassengerTicket created = service.create(passengerticket);
//        assertEquals(created.getPassengerId(), passengerticket.getPassengerId());
//        System.out.println("Create: " + created);
//    }
//
//    @Test
//    void b_read() {
//        PassengerTicket read = service.read(passengerticket.getPassengerId(), passengerticket.getTicketId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
////    @Test
////    void c_update() {
////        PassengerTicket updated = new PassengerTicket.Builder().copy(passengerticket).setPassengerId("01").setTicketId("4ff9b7f-3ac5-464a-a8e1-c02bf40bb2ab").build();
////        assertNotNull(repository.update(updated));
////        System.out.println("Update: " + updated);
////    }
//
//    @Test
//    void e_delete() {
//        boolean success = service.delete(passengerticket.getPassengerId(), passengerticket.getTicketId());
//        assertTrue(success);
//        System.out.println("Delete: " + success);
//    }
//
//    @Test
//    void d_getAll() {
//        System.out.println("Show all: ");
//        System.out.println(service.getAll());
//    }
//}