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
    private String RouteId, LocationId;

    protected LocationRoute() {}

    private LocationRoute(Builder builder){
        this.RouteId = builder.RouteId;
        this.LocationId = builder.LocationId;
    }

    public String getRouteId() {
        return RouteId;
    }

    public String getLocationId() {
        return LocationId;
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
            this.LocationId = locationRoute.LocationId;
            this.RouteId = locationRoute.RouteId;
            return this;
        }

        public LocationRoute build() {
            return new LocationRoute(this);
        }
    }

    @Override
    public String toString() {
        return "LocationRoute{" +
                "RouteId='" + RouteId + '\'' +
                ", LocationId='" + LocationId + '\'' +
                '}';
    }

    public static class LocationRouteId implements Serializable {
        private String RouteId, LocationId;

        public LocationRouteId(String routeId, String locationId) {
            this.RouteId = routeId;
            this.LocationId = locationId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LocationRouteId that = (LocationRouteId) o;
            return RouteId.equals(that.RouteId) && LocationId.equals(that.LocationId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(RouteId, LocationId);
        }
    }
}
