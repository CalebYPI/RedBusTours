package za.ac.cput.groupx30.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {

    @Test
    void createLocation() {
        Location location1 = LocationFactory.createLocation("Table Mountain","Bo-Kaap",true);
        Location location1Adjusted = new Location.Builder().copy(location1).setArea("Cape Town").build();
        System.out.println(location1);
        System.out.println(location1Adjusted);
        assertNotSame(location1, location1Adjusted);
    }
}