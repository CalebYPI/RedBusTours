package za.ac.cput.groupx30.entity;

// Author: Thokozile Snono
// Entity: Vehicle
// Date: 7 June 2021

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Vehicle implements Serializable {
    @Id
    public String Id;
    private static String desc;

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "Id='" + Id + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Vehicle(Builder builder) {
        this.Id = builder.Id;
        this.desc = builder.desc;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static class Builder {
        public String Id;
        public String desc;

        public Builder setId(String id) {
            this.Id = id;
            return this;
        }

        public Builder setDesc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder copy(Vehicle vehicle) {
            this.Id = vehicle.Id;
            this.desc = vehicle.desc;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
