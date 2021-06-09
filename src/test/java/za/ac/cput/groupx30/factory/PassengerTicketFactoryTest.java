package za.ac.cput.groupx30.factory;
/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: TestCase for PassengerTicketFactory
 * Date: 06 June 2021
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.PassengerTicket;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTicketFactoryTest {

    @Test
    void createPassengerTicket() {
        PassengerTicket passengerticket = PassengerTicketFactory.createPassengerTicket("01","74ff9b7f-3ac5-464a-a8e1-c02bf40bb2ab");
        System.out.println(passengerticket);
    }
}