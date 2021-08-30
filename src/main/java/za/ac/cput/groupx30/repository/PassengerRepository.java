package za.ac.cput.groupx30.repository;
/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Repository Interface for Passenger
 * Date: 24 July 2021
 */

import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface PassengerRepository extends IRepository<Passenger, String>{
    public Set<Passenger> getAll();
}
