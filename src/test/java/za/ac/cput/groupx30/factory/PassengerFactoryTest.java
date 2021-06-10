package za.ac.cput.groupx30.factory;
/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: TestCase for PassengerFactory
 * Date: 06 June 2021
 */
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.groupx30.entity.Passenger;

import static org.junit.jupiter.api.Assertions.*;

class PassengerFactoryTest {

    @Test
     void createPassenger() {
        Passenger passenger1 = PassengerFactory.createPassenger("Shaheed", "0787092205");
        Passenger passenger2 = PassengerFactory.createPassenger("Robert", "0787547693");
        System.out.println(passenger1 + "\n" + passenger2);

    }

    @Test
    @Disabled
    void comparePassengers() {
        Passenger passenger1 = PassengerFactory.createPassenger("Shaheed", "0787092205");
        Passenger passenger2 = PassengerFactory.createPassenger("Robert", "0787547693");
        System.out.println(passenger1 + " " + passenger2);
        assertSame(passenger1, passenger2);

    }


}