package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: DriverVehicleFactory
// Date: 7 June 2021

import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.util.Helper;

public class DriverVehicleFactory {
    public static DriverVehicle createDriverVehicle(String driverId, String vehicleId)
    {

        DriverVehicle driverVehicle = new DriverVehicle.Builder()
                .setDriverId(driverId)
                .setVehicleId(vehicleId)
                .build();

        return driverVehicle;
    }
}
