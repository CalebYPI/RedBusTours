package za.ac.cput.groupx30.factory;

import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.util.Helper;

public class PassengerTicketFactory {

    public static PassengerTicket createPassengerTicket(String passengerId, String ticketId){
        PassengerTicket passengerTicket = new PassengerTicket.Builder()
                .setPassengerId(passengerId)
                .setTicketId(ticketId)
                .build();

        return passengerTicket;
    }
}
