package za.ac.cput.groupx30.service.impl;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Service Implementation for Passenger
 * Date: 31 July 2021
 */

import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.repository.PassengerRepository;
import za.ac.cput.groupx30.repository.impl.PassengerRepositoryImpl;
import za.ac.cput.groupx30.service.PassengerService;

import java.util.Set;

@Service
public class PassengerServiceImpl implements PassengerService {
    private static PassengerServiceImpl service = null;
    private PassengerRepository repository = null;

    private PassengerServiceImpl(){
        this.repository = PassengerRepositoryImpl.getRepository();
    }

    public static PassengerServiceImpl getService(){
        if(service == null) {
            service = new PassengerServiceImpl();
        }
        return service;
    }

    @Override
    public Passenger create(Passenger passenger) {
        return this.repository.create(passenger);
    }

    @Override
    public Passenger read(String passengerId) {
        return this.repository.read(passengerId);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return this.repository.update(passenger);
    }

    @Override
    public boolean delete(String passengerId) {
        return this.repository.delete(passengerId);
    }

    @Override
    public Set<Passenger> getAll() {
        return this.repository.getAll();
    }
}
