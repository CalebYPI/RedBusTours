package za.ac.cput.groupx30.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.Vehicle;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    //Set<Vehicle> getAll();
}
