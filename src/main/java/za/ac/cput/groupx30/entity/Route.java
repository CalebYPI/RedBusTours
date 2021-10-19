package za.ac.cput.groupx30.entity;
/*
 Route.java
 Entity for the Route
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Route implements Serializable {
    @Id
    private String id;
    private String description;
    private double distance;
    private double time;

    public Route() {
    }

    private Route(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.distance = builder.distance;
        this.time = builder.time;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public static class Builder {
        private String id;
        private String description;
        private double distance;
        private double time;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDistance(double distance) {
            this.distance = distance;
            return this;
        }

        public Builder setTime(double time) {
            this.time = time;
            return this;
        }

        public Builder copy(Route route) {
            this.id = route.id;
            this.description = route.description;
            this.distance = route.distance;
            this.time = route.time;
            return this;
        }

        public Route build() {
            return new Route(this);
        }
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", distance in kilometers=" + distance +
                ", time in hours=" + time +
                '}';
    }
}
