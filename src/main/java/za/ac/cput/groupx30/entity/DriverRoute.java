package za.ac.cput.groupx30.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

/**
 * Baron Mukenyi (217163742)
 * Driver Route Entity
 * 7 May 2021
 */

@Entity
@IdClass(DriverRoute.DriverRouteId.class)
public class DriverRoute implements Serializable {
    @Id
    public String driverID, routeID;

    public DriverRoute() {
    }

    public DriverRoute(Builder builder) {
        this.driverID = builder.driverID;
        this.routeID = builder.routeID;
    }

    //getters
    public String getDriverID() {
        return driverID;
    }

    public String getRouteID() {
        return routeID;
    }
    //setters

    public static class Builder {
        public String driverID;
        public String routeID;

        public Builder setDriverID(String driverID) {
            this.driverID = driverID;
            return this;
        }

        public Builder setRouteID(String routeID) {
            this.routeID = routeID;
            return this;
        }

        public DriverRoute.Builder copy(DriverRoute driverRoute) {
            this.driverID = driverRoute.driverID;
            this.routeID = driverRoute.routeID;
            return this;
        }

        public DriverRoute build() {
            return new DriverRoute(this);
        }
    }

    public static class DriverRouteId implements Serializable {
        public DriverRouteId() {
        }

        public String driverID;
        public String routeID;

        public DriverRouteId(String driverID, String routeID) {
            this.driverID = driverID;
            this.routeID = routeID;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DriverRouteId that = (DriverRouteId) o;
            return driverID.equals(that.driverID) && routeID.equals(that.routeID);
        }

        @Override
        public int hashCode() {
            return Objects.hash(driverID, routeID);
        }
    }
}
