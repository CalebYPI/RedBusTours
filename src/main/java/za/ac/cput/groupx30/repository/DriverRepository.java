package za.ac.cput.groupx30.repository;

// Author: Thokozile Snono
// Student number: 216032121
// Entity: DriverRepository
// Date: 26 July 2021

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.Driver;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;
@Repository
public interface DriverRepository extends JpaRepository< Driver, String> {
    //Set< Driver > getAll();
}
