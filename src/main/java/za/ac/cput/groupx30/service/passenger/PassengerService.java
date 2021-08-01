package za.ac.cput.groupx30.service.passenger;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Service Interface for Passenger
 * Date: 31 July 2021
 */

import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface PassengerService extends IService<Passenger, String> {
    Set<Passenger> getAll();
}
