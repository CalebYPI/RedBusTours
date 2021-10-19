package za.ac.cput.groupx30.factory;
/*
 LocationFactoryTest.java
 Test Factory for the Location
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.groupx30.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {

    @Test
    void createLocation() {
        //Object Identity
        Location location1 = LocationFactory.createLocation("Table Mountain", "Bo-Kaap", true);
        Location location1Adjusted = new Location.Builder().copy(location1).setArea("Cape Town").build();
        System.out.println(location1);
        System.out.println(location1Adjusted);
        assertSame(location1.getId(), location1Adjusted.getId());
    }

    @Test
    void sameLocation() {
        //Object Equality
        Location location1 = LocationFactory.createLocation("Moulle's Point", "Seapoint", false);
        Location location2 = new Location.Builder().copy(location1).setDescription("Pavilion").build();
        assertEquals(location1.getArea(), location2.getArea());
    }

    @Test
    @Timeout(5)
    void timedOutLocation() throws InterruptedException {
        //Timeout
        Thread.sleep(6000);
        createLocation();
    }

    @Test
    @Disabled
    void disablingLocation() {
        //Disabling Test
        Location location1 = LocationFactory.createLocation("Table Mountain", "Bo-Kaap", true);
        System.out.println(location1);
    }
}