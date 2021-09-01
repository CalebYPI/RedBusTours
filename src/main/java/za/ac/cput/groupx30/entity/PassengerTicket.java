package za.ac.cput.groupx30.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Factory for PassengerTicket
 * Date: 06 June 2021
 */
@Entity
@IdClass(PassengerTicket.PassengerTicketId.class)
public class PassengerTicket implements Serializable {
    @Id
    private String passengerId, ticketId;

    protected PassengerTicket(){

    }

    private PassengerTicket(Builder builder){
        this.passengerId = builder.passengerId;
        this.ticketId = builder.ticketId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return "PassengerTicket{" +
                "PassengerId='" + passengerId + '\'' +
                ", TicketId='" + ticketId + '\'' +
                '}';
    }

    public static class Builder{
        public String passengerId;
        public String ticketId;

        public Builder setPassengerId(String passengerId) {
            this.passengerId = passengerId;
            return this;
        }

        public Builder setTicketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public PassengerTicket.Builder copy(PassengerTicket passengerTicket){
            this.passengerId = passengerTicket.passengerId;
            this.ticketId = passengerTicket.ticketId;

            return this;
        }

        public PassengerTicket build(){
            return new PassengerTicket(this);
        }
    }

    public static class PassengerTicketId implements Serializable{
        private String passengerId, ticketId;

        public PassengerTicketId(String passengerId, String ticketId){
            this.passengerId = passengerId;
            this.ticketId = ticketId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PassengerTicketId that = (PassengerTicketId) o;
            return passengerId.equals(that.passengerId) && ticketId.equals(that.ticketId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(passengerId, ticketId);
        }
    }
}
