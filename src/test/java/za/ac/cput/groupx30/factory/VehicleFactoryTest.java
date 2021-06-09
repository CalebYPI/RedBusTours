package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: VehicleFactoryTest
// Date: 11 June 2021

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Vehicle;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

class VehicleFactoryTest {

    @Test
    void createVehicle() {
        String vehicle = "Mercedes Benz";
        Vehicle vehicle1 = VehicleFactory.createVehicle(vehicle);
        Assertions.assertEquals(vehicle1, vehicle1);
        Assertions.assertSame("Mercedes Benz", "Mercedes Benz");
        Assertions.assertNotNull(vehicle1);
        Assertions.assertNotNull(vehicle1.desc);
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.Timeout(value = 1000, unit = NANOSECONDS)
    public void setId() {
    }

    @Test
    @Disabled
    @DisplayName("TDD method should not run")
    public void testDisable() {
        org.junit.jupiter.api.Assertions.fail("This test should be disabled");
    }
}