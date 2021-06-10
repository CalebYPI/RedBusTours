package za.ac.cput.groupx30.entity;

import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Entity for Ticket
 * Date: 06 June 2021
 */
public class Ticket {
    private String Id;
    private String Date;
    private String Time;
    private String Price;


    protected Ticket(){

    }

    private Ticket(Ticket.Builder builder){
        this.Id = builder.Id;
        this.Date = builder.Date;
        this.Time = builder.Time;
        this.Price = builder.Price;
    }

    public String getId() {
        return Id;
    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public String getPrice() {
        return Price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Id='" + Id + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", Price='" + Price + '\'' +
                '}';
    }

    public static class Builder{
        public String Id;
        public String Date;
        public String Time;
        public String Price;

        public Builder setId(String id) {
            Id = id;
            return this;
        }

        public Builder setDate(String date) {
            Date = date;
            return this;
        }

        public Builder setTime(String time) {
            Time = time;
            return this;
        }

        public Builder setPrice(String price) {
            Price = price;
            return this;
        }

        public Ticket.Builder copy(Ticket ticket){
            this.Id = ticket.Id;
            this.Date = ticket.Date;
            this.Time = ticket.Time;
            this.Price = ticket.Price;

            return this;
        }

        public Ticket build(){
            return new Ticket(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(Id, ticket.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
