package za.ac.cput.groupx30.entity;

// Author: Thokozile Snono
// Entity: DriverVehicle
// Date: 7 June 2021

public class DriverVehicle {
    public String driverId, vehicleId;

    public DriverVehicle(Builder builder) {
        this.driverId = builder.driverId;
        this.vehicleId = builder.vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId){
        this.driverId = driverId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId){
        this.vehicleId = vehicleId;
    }

    public static class Builder{
        public String driverId, vehicleId;

        public Builder setDriverId(String driverId){
            this.driverId = driverId;
            return this;
        }

        public Builder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder copy(DriverVehicle driverVehicle){
            this.driverId = driverVehicle.driverId;
            this.vehicleId = driverVehicle.vehicleId;
            return this;
        }

        public DriverVehicle build(){
                return new DriverVehicle(this);
            }
        }
}

