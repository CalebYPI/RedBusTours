package za.ac.cput.groupx30.repository.location;

/*
 LocationRepository.java
 Repository for the Location
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/

import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface LocationRepository extends IRepository<Location, String> {
    Set<Location> getAll();
}
