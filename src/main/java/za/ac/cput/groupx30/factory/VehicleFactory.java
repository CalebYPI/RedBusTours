package za.ac.cput.groupx30.factory;

import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.util.Helper;

public class VehicleFactory {
    public static Vehicle createVehicle(String desc)
    {
        String id = Helper.generateId();

        Vehicle vehicle = new Vehicle.Builder()
                .setDesc(desc)
                .setId(id)
                .build();

        return vehicle;
    }
}
