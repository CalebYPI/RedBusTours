package za.ac.cput.groupx30.repository.location;

/*
 LocationRepository.java
 Repository for the Location
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.Location;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;
@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
}
