package za.ac.cput.groupx30.entity;
/*
 Location.java
 Entity for the Location
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Location implements Serializable {
    @Id
    private String id;
    private String description;
    private String area;
    private boolean pickupPoint;

    public Location() {}

    private Location(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.area = builder.area;
        this.pickupPoint = builder.pickupPoint;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getArea() {
        return area;
    }

    public boolean isPickupPoint() {
        return pickupPoint;
    }

    public static class Builder {
        private String id;
        private String description;
        private String area;
        private boolean pickupPoint;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setArea(String area) {
            this.area = area;
            return this;
        }

        public Builder setPickupPoint(boolean pickupPoint) {
            this.pickupPoint = pickupPoint;
            return this;
        }

        public Builder copy(Location location) {
            this.id = location.id;
            this.description = location.description;
            this.area = location.area;
            this.pickupPoint = location.pickupPoint;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", area='" + area + '\'' +
                ", pickupPoint=" + pickupPoint +
                '}';
    }
}
