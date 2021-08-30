//package za.ac.cput.groupx30.repository.impl;
//
///**
// * Author: Shaheed_Cloete(213239442)
// * Desc: Repository Implementation for Passenger
// * Date: 24 July 2021
// */
//
//import za.ac.cput.groupx30.entity.Passenger;
//import za.ac.cput.groupx30.repository.PassengerRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class PassengerRepositoryImpl implements PassengerRepository {
//    private static PassengerRepositoryImpl repository = null;
//    private Set<Passenger> passengerDB = null;
//
//    private PassengerRepositoryImpl(){
//        passengerDB = new HashSet<Passenger>();
//    }
//
//    public static PassengerRepositoryImpl getRepository(){
//        if (repository == null) {
//            repository = new PassengerRepositoryImpl();
//        }
//        return repository;
//    }
//
//    @Override
//    public Passenger create(Passenger passenger) {
//        boolean created = passengerDB.add(passenger);
//        if (!created){
//            return null;
//        }
//        return passenger;
//    }
//
//    @Override
//    public Passenger read(String passengerId) {
//        for(Passenger p : passengerDB){
//            if(p.getId().equals(passengerId)){
//                return p;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Passenger update(Passenger passenger) {
//        Passenger oldPassenger = read(passenger.getId());
//        if(oldPassenger != null){
//            passengerDB.remove(oldPassenger);
//            passengerDB.add(passenger);
//            return passenger;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String passengerId) {
//        Passenger deletePassenger = read(passengerId);
//        if(deletePassenger == null){
//            return false;
//        }
//        passengerDB.remove(deletePassenger);
//        return true;
//    }
//
//    @Override
//    public Set<Passenger> getAll() {
//        return passengerDB;
//    }
//}