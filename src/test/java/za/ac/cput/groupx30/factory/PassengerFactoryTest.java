package za.ac.cput.groupx30.factory;
/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: TestCase for PassengerFactory
 * Date: 06 June 2021
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Passenger;

import static org.junit.jupiter.api.Assertions.*;

class PassengerFactoryTest {

    @Test
    void createPassenger() {
        Passenger passenger = PassengerFactory.createPassenger("","Shaheed", "0787092205");
        System.out.println(passenger);
    }
}