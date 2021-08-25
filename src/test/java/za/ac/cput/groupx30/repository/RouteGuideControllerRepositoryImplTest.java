//package za.ac.cput.groupx30.repository;
//
///*  RouteGuideRepositoryImplTest.java
// *  Author: Thaakir Ajouhaar (217244394)
// *  Date: 26 July 2021
// */
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.groupx30.entity.RouteGuide;
//import za.ac.cput.groupx30.factory.RouteGuideFactory;
//import za.ac.cput.groupx30.repository.route.RouteGuideRepository;
//import za.ac.cput.groupx30.repository.route.impl.RouteGuideRepositoryImpl;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//public class RouteGuideControllerRepositoryImplTest
//{
//    private RouteGuideRepository repository = RouteGuideRepositoryImpl.getRepository();
//    private static RouteGuide routeGuide = RouteGuideFactory.createRouteGuide("805245" , "Wilderness Tour");
//
//    @Test
//    void create()
//    {
//        RouteGuide create = repository.create(routeGuide);
//        assertEquals(create.getRouteId(), routeGuide.getRouteId());
//        assertEquals(create.getGuideId(), routeGuide.getGuideId());
//        System.out.println("Created:" + create);
//
//    }
//
//    @Test
//    void read()
//    {
//        RouteGuide read = repository.read(routeGuide.getRouteId(), routeGuide.getGuideId());
//        assertNotNull(read);
//        System.out.println("Read:" + read);
//    }
//
//    @Test
//    void delete()
//    {
//        boolean delete = repository.delete(routeGuide.getRouteId(), routeGuide.getGuideId());
//        assertTrue(delete);
//        System.out.println("Deleted:" + delete);
//    }
//}
//
//
