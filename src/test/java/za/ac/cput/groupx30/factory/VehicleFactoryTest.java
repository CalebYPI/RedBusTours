package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: VehicleFactoryTest
// Date: 11 June 2021

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Vehicle;

import static java.util.concurrent.TimeUnit.SECONDS;

class VehicleFactoryTest {

    String vehicle = "Mercedes Benz";
    Vehicle vehicle1 = VehicleFactory.createVehicle(vehicle);

    @Test
    void testEquality() {
        Assertions.assertEquals(vehicle1, vehicle1);
        Assertions.assertNotNull(vehicle1);
        //Assertions.assertNotNull(vehicle1.desc);
    }

    @Test
    void testIdentity() {
        Assertions.assertSame("Mercedes Benz", "Mercedes Benz");
    }

    @Test
    @org.junit.jupiter.api.Timeout(value = 1, unit = SECONDS)
    public void setId() {
        //while(true);
    }

    @Test
    @Disabled
    void setVehicleId() {
    }
}