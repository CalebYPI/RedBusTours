package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: DriverVehicleFactoryTest
// Date: 11 June 2021

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.DriverVehicle;

import static java.util.concurrent.TimeUnit.SECONDS;

class DriverVehicleFactoryTest {

    String driverVehicle = "Bus1";
    DriverVehicle driverVehicle1 = DriverVehicleFactory.createDriverVehicle(driverVehicle);

    @Test
    void testEqualityId() {
        Assertions.assertEquals(driverVehicle1, driverVehicle1);
        Assertions.assertNotNull(driverVehicle1);
        Assertions.assertNotNull(driverVehicle1.getVehicleId());
    }

    @Test
    void testIdentityId(){
        Assertions.assertSame("Bus1", "Bus1");
    }

    @Test
    @org.junit.jupiter.api.Timeout(value = 1, unit = SECONDS)
    public void setId(){
        //while(true);
    }

    @Test
    @Disabled
    void setDriverVehicleId() {
    }
}