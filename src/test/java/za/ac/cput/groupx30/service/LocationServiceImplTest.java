package za.ac.cput.groupx30.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.factory.LocationFactory;
import za.ac.cput.groupx30.service.impl.LocationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LocationServiceImplTest {
    public static LocationService service = LocationServiceImpl.getService();
    public static Location moullesPoint = LocationFactory.createLocation("Moulle's Point", "Sea Point", true);

    @Test
    void a_create() {
        Location create = service.create(moullesPoint);
        assertEquals(moullesPoint.getId(), create.getId());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        Location read = service.read(moullesPoint.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Location update = new Location.Builder().copy(moullesPoint).setPickupPoint(false).build();
        update = service.update(update);
        assertEquals(moullesPoint.getId(), update.getId());
        System.out.println("Updated: " + update);
    }

    @Test
    void e_delete() {
        boolean delete = service.delete(moullesPoint.getId());
        assertTrue(delete);
        System.out.println("Deleted: " + delete);
    }

    @Test
    void d_getAll() {
        assertEquals(1, service.getAll().size());
        System.out.println("All Locations: " + service.getAll());
    }
}