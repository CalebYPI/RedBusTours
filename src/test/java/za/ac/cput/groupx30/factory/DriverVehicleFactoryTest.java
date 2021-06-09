package za.ac.cput.groupx30.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.DriverVehicle;

class DriverVehicleFactoryTest {

    @Test
    void createDriverVehicle() {
        String driverVehicle = "Bus1";
        DriverVehicle driverVehicle1 = DriverVehicleFactory.createDriverVehicle(driverVehicle);
        Assertions.assertNotNull(driverVehicle1);
        Assertions.assertNotNull(driverVehicle1.getVehicleId());
    }
}