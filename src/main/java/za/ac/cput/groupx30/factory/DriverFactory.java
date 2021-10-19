package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: DriverFactory
// Date: 7 June 2021

import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.util.Helper;

public class DriverFactory {
    public static Driver createId(String name) {
        String Id = Helper.generateId();

        Driver driver = new Driver.Builder()
                .setId(Id)
                .setName(name)
                .build();

        return driver;
    }
}
