package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: VehicleFactoryTest
// Date: 11 June 2021

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Vehicle;

class VehicleFactoryTest {

    @Test
    void createVehicle() {
        String vehicle = "Mercedes Benz";
        Vehicle vehicle1 = VehicleFactory.createVehicle(vehicle);
        Assertions.assertNotNull(vehicle1);
        Assertions.assertNotNull(vehicle1.desc);
    }
}