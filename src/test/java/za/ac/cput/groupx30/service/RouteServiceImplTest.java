//package za.ac.cput.groupx30.service;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.groupx30.entity.Route;
//import za.ac.cput.groupx30.factory.RouteFactory;
//import za.ac.cput.groupx30.repository.route.RouteRepository;
//import za.ac.cput.groupx30.repository.route.impl.RouteRepositoryImpl;
//import za.ac.cput.groupx30.service.route.RouteService;
//import za.ac.cput.groupx30.service.route.impl.RouteServiceImpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class RouteServiceImplTest {
//
//    private static RouteService service = RouteServiceImpl.getService();
//    private static Route red = RouteFactory.createRoute("Red Route", 20, 20);
//
//    @Test
//    void a_create() {
//        Route create = service.create(red);
//        assertEquals(red.getId(), create.getId());
//        System.out.println("Created: " + create);
//    }
//
//    @Test
//    void b_read() {
//        Route read = service.read(red.getId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void c_update() {
//        Route update = new Route.Builder().copy(red).setTime(120).build();
//        update = service.update(update);
//        assertEquals(red.getId(), update.getId());
//        System.out.println("Updated: " + update);
//    }
//
//    @Test
//    void e_delete() {
//        boolean delete = service.delete(red.getId());
//        assertTrue(delete);
//        System.out.println("Deleted: " + delete);
//    }
//
//    @Test
//    void d_getAll() {
//        assertEquals(1, service.getAll().size());
//        System.out.println("All Routes: " + service.getAll());
//    }
//}