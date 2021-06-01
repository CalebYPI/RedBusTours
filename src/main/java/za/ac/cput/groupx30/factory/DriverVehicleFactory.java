package za.ac.cput.groupx30.factory;

import za.ac.cput.groupx30.entity.DriverVehicle;
import za.ac.cput.groupx30.util.Helper;

public class DriverVehicleFactory {
    public static DriverVehicle createDriverVehicle(String vehicleId)
    {
        String driverId = Helper.generateId();

        DriverVehicle driverVehicle = new DriverVehicle.Builder()
                .setDriverId(driverId)
                .setVehicleId(vehicleId)
                .build();

        return driverVehicle;
    }
}
