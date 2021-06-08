package za.ac.cput.groupx30.entity;



public class DriverRoute {
    public String driverID, routeID;

    public DriverRoute(Builder builder){
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
    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public static class Builder{
        public String driverID;
        public String routeID;

        public Builder setDriverID(String driverID){
            this.driverID = driverID;
            return this;
        }
        public Builder setRouteID(String routeID){
            this.routeID = routeID;
            return this;
        }

        public DriverRoute build(){
            return new DriverRoute(this);
        }
    }
}
