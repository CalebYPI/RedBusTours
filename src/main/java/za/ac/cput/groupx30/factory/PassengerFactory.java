package za.ac.cput.groupx30.factory;
/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Factory for Passenger
 * Date: 06 June 2021
 */
import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.util.Helper;

public class PassengerFactory {


    public static Passenger createPassenger(String id, String name, String contact){
        id = Helper.generateId();
        Passenger passenger = new Passenger.Builder()
                .setId(id)
                .setName(name)
                .setContact(contact)
                .build();
        return passenger;
    }
}
