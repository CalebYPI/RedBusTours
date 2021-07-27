package za.ac.cput.groupx30.entity;
/*
 LocationRouteService.java
 Entity for the LocationRoute
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

public class LocationRoute {
    private String RouteId, LocationId;

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
}
