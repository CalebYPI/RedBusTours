package za.ac.cput.groupx30.entity;
/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Entity for Passenger
 * Date: 06 June 2021
 */

import java.util.Objects;

public class Passenger {

    private String id;
    private String name;
    private String contact;

    protected Passenger(){

    }

    private Passenger(Builder builder){
        this.id = builder.Id;
        this.name = builder.Name;
        this.contact = builder.Contact;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "Id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Contact='" + contact + '\'' +
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
            this.Id = passenger.id;
            this.Name = passenger.name;
            this.Contact = passenger.contact;

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
        return Objects.equals(id, passenger.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
