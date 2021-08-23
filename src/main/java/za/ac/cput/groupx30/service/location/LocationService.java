package za.ac.cput.groupx30.service.location;

import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;


public interface LocationService extends IService<Location, String> {
    Set<Location> getAll();
}
