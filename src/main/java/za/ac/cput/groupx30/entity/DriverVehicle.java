package za.ac.cput.groupx30.entity;

public class DriverVehicle {
    public String driverId;
    public String vehicleId;


    public DriverVehicle(String driverId, String vehicleId) {
        this.driverId = driverId;
        this.vehicleId = vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}
