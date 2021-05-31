package za.ac.cput.groupx30.entity;

public class Vehicle {
    public String Id;
    public String desc;

    public Vehicle(String id, String desc) {
        Id = id;
        this.desc = desc;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
