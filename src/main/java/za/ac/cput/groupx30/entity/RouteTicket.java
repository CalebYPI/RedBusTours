package za.ac.cput.groupx30.entity;

/**
 * Baron Mukenyi (217163742)
 * Class repository for Ticket Route
 * 07 May 2021
 */

public class RouteTicket {
    public String route, routeDesc;

    public RouteTicket(Builder builder){
        this.route = builder.route;
        this.routeDesc = builder.routeDesc;
    }

    //getter and setters
    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRouteDesc() {
        return routeDesc;
    }

    public void setRouteDesc(String routeDesc) {
        this.routeDesc = routeDesc;
    }

    public static class Builder{
        public String route;
        public String routeDesc;

        public Builder setRoute(String route){
            this.route = route;
            return this;
        }
        public Builder setRouteDesc(String routeDesc){
            this.routeDesc = routeDesc;
            return this;
        }

        public RouteTicket.Builder copy(RouteTicket routeTicket){
            this.route = routeTicket.route;
            this.routeDesc = routeTicket.routeDesc;
            return this;
        }

        public RouteTicket build(){
            return new RouteTicket(this);
        }
    }
}
