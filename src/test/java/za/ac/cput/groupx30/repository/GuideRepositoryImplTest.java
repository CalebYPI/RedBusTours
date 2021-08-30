//package za.ac.cput.groupx30.repository;
//
///*  GuideRepositoryImplTest.java
// *  Author: Thaakir Ajouhaar (217244394)
// *  Date: 26 July 2021
// */
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.groupx30.entity.Guide;
//import za.ac.cput.groupx30.factory.GuideFactory;
//import za.ac.cput.groupx30.repository.GuideRepository;
//import za.ac.cput.groupx30.repository.guide.impl.GuideRepositoryImpl;
//
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class GuideRepositoryImplTest
//{
//    private GuideRepository repository = GuideRepositoryImpl.getRepository();
//    private static Guide guide = GuideFactory.createId("Chapmans Peak Guide", "357234");
//
//    @Test
//    void create()
//    {
//        Guide create = repository.create(guide);
//        assertEquals(create.getId(), guide.getId());
//        System.out.println("Created:" + create);
//    }
//
//    @Test
//    void read()
//    {
//        Guide read = repository.read(guide.getId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    void update()
//    {
//        Guide update = new Guide.Builder().copy(guide).setId("586742").build();
//        update = repository.update(update);
//        assertEquals(update.getId(), guide.getId());
//        System.out.println("Updated: " + update);
//    }
//
//    @Test
//    void delete()
//    {
//        boolean deleted = repository.delete(guide.getId());
//        assertTrue(deleted);
//        System.out.println("Deleted: " + deleted);
//    }
//
//    @Test
//    void getAll()
//    {
//        Set<Guide> guides = repository.getAll();
//        assertEquals(1, guides.size());
//        System.out.println("All Guides: " + guides);
//    }
//
//}
//
