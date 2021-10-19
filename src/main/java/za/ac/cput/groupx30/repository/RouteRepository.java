package za.ac.cput.groupx30.repository;

/*
 RouteRepository.java
 Repository for the Route
 Author: Caleb Ruiters (215169751)
 Date: 20 June 2021
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {
}
