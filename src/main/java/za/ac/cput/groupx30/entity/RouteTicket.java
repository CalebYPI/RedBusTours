package za.ac.cput.groupx30.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

/**
 * Baron Mukenyi (217163742)
 * Class repository for Ticket Route
 * 07 May 2021
 * 27 August 2021, JPARepository
 */


@Entity
@IdClass(RouteTicket.RouteTicketID.class)
public class RouteTicket implements Serializable {
    @Id
    private String route, ticketID;

    protected RouteTicket(){}

    public RouteTicket(Builder builder){
        this.route = builder.route;
        this.ticketID = builder.ticketID;
    }

    //getter and setters
    public String getRoute() {
        return route;
    }


    public String getTicketID() {
        return ticketID;
    }


    public static class Builder{
        public String route;
        public String ticketID;

        public Builder setRoute(String route){
            this.route = route;
            return this;
        }
        public Builder setTicketID(String routeDesc){
            this.ticketID = ticketID;
            return this;
        }

        public RouteTicket.Builder copy(RouteTicket routeTicket){
            this.route = routeTicket.route;
            this.ticketID = routeTicket.ticketID;
            return this;
        }

        public RouteTicket build(){
            return new RouteTicket(this);
        }
    }

    @Override
    public String toString() {
        return "RouteTicket{" +
                "route='" + route + '\'' +
                ", routeDesc='" + ticketID + '\'' +
                '}';
    }

    public static class RouteTicketID implements Serializable{
        private String route, ticketID;

        public RouteTicketID(String route, String ticketID){
            this.route = route;
            this.ticketID = ticketID;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        RouteTicket that = (RouteTicket) o;
        return getRoute().equals(that.getRoute()) && getTicketID().equals(that.getTicketID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoute(), getTicketID());
    }
}
