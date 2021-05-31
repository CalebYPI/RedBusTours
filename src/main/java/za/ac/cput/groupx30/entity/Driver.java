package za.ac.cput.groupx30.entity;

// Author: Thokozile Snono
// Entity: Driver
// Date: 7 June 2021

public class Driver {
    public String Id;
    public String name;

    public Driver(Builder builder) {
        this.Id = builder.Id;
        this.name = builder.name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder{
        public String Id;
        public String name;

        public Builder setId(String id){
            this.Id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder copy(Driver driver){
            this.Id = driver.Id;
            this.name = driver.name;
            return this;
        }

        public Driver build(){
            return new Driver(this);
        }
    }
}
