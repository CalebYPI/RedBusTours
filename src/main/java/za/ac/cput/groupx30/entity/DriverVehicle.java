package za.ac.cput.groupx30.entity;

// Author: Thokozile Snono
// Entity: DriverVehicle
// Date: 7 June 2021

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(DriverVehicle.DriverVehicleId.class)
public class DriverVehicle implements Serializable {
    @Id
    public String driverId, vehicleId;

    public DriverVehicle() {
    }

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
    public static class DriverVehicleId implements Serializable {
        public DriverVehicleId() {
        }

        public String driverId, vehicleId;

        public DriverVehicleId(String driverId, String vehicleId) {
            this.driverId = driverId;
            this.vehicleId = vehicleId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DriverVehicleId that = (DriverVehicleId) o;
            return driverId.equals(that.driverId) && vehicleId.equals(that.vehicleId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(driverId, vehicleId);
        }
    }
}

