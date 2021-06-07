package za.ac.cput.groupx30.factory;
/*
 LocationFactory.java
 Factory for the Location
 Author: Caleb Ruiters (215169751)
 Date: 31 May 2021
*/

import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.util.Helper;

public class LocationFactory {
    public static Location createLocation(String description, String area, boolean pickupPoint) {
        String id = Helper.generateId();
        if (description.isEmpty() || area.isEmpty())
            return new Location.Builder().build();
        Location location = new Location.Builder()
                .setId(id)
                .setDescription(description)
                .setArea(area)
                .setPickupPoint(pickupPoint)
                .build();
        return location;
    }
}
