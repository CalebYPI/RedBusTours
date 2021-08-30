//package za.ac.cput.groupx30.service;
//
///*  GuideServiceImplTest.java
// *  Author: Thaakir Ajouhaar (217244394)
// *  Date: 02 August 2021
// */
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.groupx30.entity.Guide;
//import za.ac.cput.groupx30.entity.RouteGuide;
//import za.ac.cput.groupx30.factory.GuideFactory;
//import za.ac.cput.groupx30.service.GuideService;
//import za.ac.cput.groupx30.service.impl.GuideServiceImpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class GuideServiceImplTest
//{
//    public static GuideService service = GuideServiceImpl.getService();
//    public static Guide Llandudno = GuideFactory.createId("Llandudno" , "356623");
//
//    @Test
//    void create()
//    {
//        Guide create = service.create(Llandudno);
//        assertEquals(Llandudno.getId(), create.getId());
//        System.out.println("Created : " + create);
//    }
//
//    @Test
//    void read()
//    {
//        Guide.GuideId id = new Guide.GuideId(Llandudno.getId(), Llandudno.getName());
//        Guide read = service.read(id);
//        assertNotNull(read);
//        System.out.println("Read : " + read);
//    }
//
////    @Test
////    void update()
////    {
////        Guide update = new Guide.Builder().copy(Llandudno).setId("542466").build();
////        update = service.update(update);
////        assertEquals(Llandudno.getId(), update.getId());
////        System.out.println("Updated : " + update);
////    }
//
//    @Test
//    void delete()
//    {
//        boolean delete = service.delete(Llandudno);
//        assertTrue(delete);
//        System.out.println("Deleted : " + delete);
//    }
//
//    @Test
//    void getAll()
//    {
//        assertEquals(service.getAll().size(), 1);
//        System.out.println("Guides: " + service.getAll());
//    }
//}
