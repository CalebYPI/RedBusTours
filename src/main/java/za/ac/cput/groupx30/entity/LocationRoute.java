package za.ac.cput.groupx30.entity;
/*
 LocationRouteService.java
 Entity for the LocationRoute
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(LocationRoute.LocationRouteId.class)
public class LocationRoute implements Serializable {
    @Id
    private String routeId, locationId;

    public LocationRoute() {
    }

    private LocationRoute(Builder builder) {
        this.routeId = builder.RouteId;
        this.locationId = builder.LocationId;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getLocationId() {
        return locationId;
    }

    public static class Builder {
        private String RouteId, LocationId;

        public Builder setRouteId(String routeId) {
            this.RouteId = routeId;
            return this;
        }

        public Builder setLocationId(String locationId) {
            this.LocationId = locationId;
            return this;
        }

        public Builder copy(LocationRoute locationRoute) {
            this.LocationId = locationRoute.locationId;
            this.RouteId = locationRoute.routeId;
            return this;
        }

        public LocationRoute build() {
            return new LocationRoute(this);
        }
    }

    @Override
    public String toString() {
        return "LocationRoute{" +
                "RouteId='" + routeId + '\'' +
                ", LocationId='" + locationId + '\'' +
                '}';
    }

    public static class LocationRouteId implements Serializable {
        public LocationRouteId() {
        }

        private String routeId, locationId;

        public LocationRouteId(String routeId, String locationId) {
            this.routeId = routeId;
            this.locationId = locationId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LocationRouteId that = (LocationRouteId) o;
            return routeId.equals(that.routeId) && locationId.equals(that.locationId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(routeId, locationId);
        }
    }
}
