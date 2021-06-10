package za.ac.cput.groupx30.entity;
/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Entity for Passenger
 * Date: 06 June 2021
 */

import java.util.Objects;

public class Passenger {

    private String Id;
    private String Name;
    private String Contact;

    protected Passenger(){

    }

    private Passenger(Builder builder){
        this.Id = builder.Id;
        this.Name = builder.Name;
        this.Contact = builder.Contact;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getContact() {
        return Contact;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Contact + '\'' +
                '}';
    }

    public static class Builder{
        public String Id;
        public String Name;
        public String Contact;

        public Builder setId(String id) {
            Id = id;
            return this;
        }

        public Builder setName(String name) {
            Name = name;
            return this;
        }

        public Builder setContact(String contact) {
            Contact = contact;
            return this;
        }

        public Passenger.Builder copy(Passenger passenger){
            this.Id = passenger.Id;
            this.Name = passenger.Name;
            this.Contact = passenger.Contact;

            return this;
        }

        public Passenger build(){
            return new Passenger(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(Id, passenger.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
