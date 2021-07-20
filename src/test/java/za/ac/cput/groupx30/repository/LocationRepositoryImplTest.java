package za.ac.cput.groupx30.repository;
/*
 LocationRepositoryImplTest.java
 Test Repository Implementation for the Location
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.LocationFactory;
import za.ac.cput.groupx30.repository.location.LocationRepository;
import za.ac.cput.groupx30.repository.location.impl.LocationRepositoryImpl;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LocationRepositoryImplTest {
    private LocationRepository repository = LocationRepositoryImpl.getRepository();
    private static Location location = LocationFactory.createLocation("Waterfront", "Foreshore", true);

    @Test
    void a_create() {
        Location created = repository.create(location);
        assertEquals(created.getId(), location.getId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Location read = repository.read(location.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Location updated = new Location.Builder().copy(location).setDescription("Blue Route").build();
        updated = repository.update(updated);
        assertEquals(updated.getId(), location.getId());
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean deleted = repository.delete(location.getId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void d_getAll() {
        Set<Location> locations = repository.getAll();
        assertEquals(1, locations.size());
        System.out.println("All Locations: " + locations);
    }
}