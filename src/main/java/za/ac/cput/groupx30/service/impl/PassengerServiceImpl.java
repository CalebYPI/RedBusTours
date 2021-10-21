package za.ac.cput.groupx30.service.impl;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Service Implementation for Passenger
 * Date: 31 July 2021
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Passenger;
import za.ac.cput.groupx30.factory.PassengerFactory;
import za.ac.cput.groupx30.repository.PassengerRepository;
//import za.ac.cput.groupx30.repository.impl.PassengerRepositoryImpl;
import za.ac.cput.groupx30.service.PassengerService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {

    private static PassengerServiceImpl service = null;

    @Autowired
    private PassengerRepository repository;

    @Override
    public Passenger create(Passenger passenger) {
        return this.repository.save(passenger);
    }

    @Override
    public Passenger read(String passengerId) {
        return this.repository.findById(passengerId).orElse(null);
    }

    @Override
    public Passenger update(Passenger passenger) {
        if (this.repository.existsById(passenger.getId())) {
            return this.repository.save(passenger);
        }
        return null;
    }

    @Override
    public boolean delete(String passengerId) {
        this.repository.deleteById(passengerId);
        if (this.repository.existsById(passengerId)) {
            return false;
        } else
            return true;
    }

    @Override
    public Set<Passenger> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


//    private static PassengerServiceImpl service = null;
//    private PassengerRepository repository = null;
//
//    private PassengerServiceImpl(){
//        this.repository = PassengerRepositoryImpl.getRepository();
//    }
//
//    public static PassengerServiceImpl getService(){
//        if(service == null) {
//            service = new PassengerServiceImpl();
//        }
//        return service;
//    }
//
//    @Override
//    public Passenger create(Passenger passenger) {
//        return this.repository.create(passenger);
//    }
//
//    @Override
//    public Passenger read(String passengerId) {
//        return this.repository.read(passengerId);
//    }
//
//    @Override
//    public Passenger update(Passenger passenger) {
//        return this.repository.update(passenger);
//    }
//
//    @Override
//    public boolean delete(String passengerId) {
//        return this.repository.delete(passengerId);
//    }
//
//    @Override
//    public Set<Passenger> getAll() {
//        return this.repository.getAll();
//    }
}
