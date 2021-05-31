package za.ac.cput.groupx30.entity;

public class Driver {
    public String Id;
    public String name;

    public Driver(String id, String name) {
        Id = id;
        this.name = name;
    }

    public Driver() {
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
}
