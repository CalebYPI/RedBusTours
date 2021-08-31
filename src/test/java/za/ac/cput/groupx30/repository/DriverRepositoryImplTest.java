//package za.ac.cput.groupx30.repository;
//
//// Author: Thokozile Snono
//// Student number: 216032121
//// Entity: DriverRepositoryImpl Test
//// Date: 26 July 2021
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.groupx30.entity.Driver;
//import za.ac.cput.groupx30.factory.DriverFactory;
//import za.ac.cput.groupx30.repository.impl.DriverRepositoryImpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class DriverRepositoryImplTest {
//
//    private static DriverRepository repository = DriverRepositoryImpl.getRepository();
//    private static Driver driver = DriverFactory.createId("Mr Grey");
//
//    @Test
//    public void a_create(){
//        Driver created = repository.create(driver);
//        assertEquals(driver.getId(), created.getId());
//        assertEquals(driver.getName(), created.getName());
//        System.out.println("CreatedRoom: " + created);
//    }
//
//    @Test
//    public void b_read(){
//        Driver read = repository.read(driver.getId());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update(){
//        Driver updated = new Driver.Builder().copy(driver).setId("Mr Grey").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete(){
//        boolean deleted = repository.delete(driver.getId());
//        assertTrue(deleted);
//        System.out.println("Successfully deleted!");
//    }
//
//    @Test
//    public void d_getAll(){
//        System.out.println("Get all: " + repository.getAll());
//    }
//}