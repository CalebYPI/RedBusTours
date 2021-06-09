package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: DriverVehicleFactoryTest
// Date: 11 June 2021

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.DriverVehicle;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

class DriverVehicleFactoryTest {

    @Test
    void createDriverVehicle() {
        String driverVehicle = "Bus1";
        DriverVehicle driverVehicle1 = DriverVehicleFactory.createDriverVehicle(driverVehicle);
        Assertions.assertEquals(driverVehicle1, driverVehicle1);
        Assertions.assertSame("Bus1", "Bus1");
        Assertions.assertNotNull(driverVehicle1);
        Assertions.assertNotNull(driverVehicle1.getVehicleId());
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