package za.ac.cput.groupx30.entity;
/*
 * Author: Shaheed_Cloete(213239442)
 * Desc: Entity for Passenger
 * Date: 06 June 2021
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Passenger implements Serializable {

    @Id
    private String id;
    private String name;
    private String contact;

    public Passenger() {

    }

    private Passenger(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.contact = builder.contact;
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

    public static class Builder {
        public String id;
        public String name;
        public String contact;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public Passenger.Builder copy(Passenger passenger) {
            this.id = passenger.id;
            this.name = passenger.name;
            this.contact = passenger.contact;

            return this;
        }

        public Passenger build() {
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
