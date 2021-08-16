package za.ac.cput.groupx30.entity;

import java.util.Objects;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Factory for PassengerTicket
 * Date: 06 June 2021
 */
public class PassengerTicket {
    private String PassengerId;
    private String TicketId;

    protected PassengerTicket(){

    }

    private PassengerTicket(Builder builder){
        this.PassengerId = builder.PassengerId;
        this.TicketId = builder.TicketId;
    }

    public String getPassengerId() {
        return PassengerId;
    }

    public String getTicketId() {
        return TicketId;
    }

    @Override
    public String toString() {
        return "PassengerTicket{" +
                "PassengerId='" + PassengerId + '\'' +
                ", TicketId='" + TicketId + '\'' +
                '}';
    }

    public static class Builder{
        public String PassengerId;
        public String TicketId;

        public Builder setPassengerId(String passengerId) {
            PassengerId = passengerId;
            return this;
        }

        public Builder setTicketId(String ticketId) {
            TicketId = ticketId;
            return this;
        }

        public PassengerTicket.Builder copy(PassengerTicket passengerTicket){
            this.PassengerId = passengerTicket.PassengerId;
            this.TicketId = passengerTicket.TicketId;

            return this;
        }

        public PassengerTicket build(){
            return new PassengerTicket(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerTicket that = (PassengerTicket) o;
        return Objects.equals(PassengerId, that.PassengerId) && Objects.equals(TicketId, that.TicketId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PassengerId, TicketId);
    }
}
