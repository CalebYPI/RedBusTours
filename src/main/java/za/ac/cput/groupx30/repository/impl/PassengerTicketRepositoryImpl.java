//package za.ac.cput.groupx30.repository.impl;
//
///**
// * Author: Shaheed_Cloete(213239442)
// * Desc: Repository Implementation for PassengerTicket
// * Date: 24 July 2021
// */
//
//import za.ac.cput.groupx30.entity.PassengerTicket;
//import za.ac.cput.groupx30.repository.PassengerTicketRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//public class PassengerTicketRepositoryImpl implements PassengerTicketRepository {
//    private static PassengerTicketRepositoryImpl repository = null;
//    private Set<PassengerTicket> passengerTicketDB = null;
//
//    private PassengerTicketRepositoryImpl(){
//        passengerTicketDB = new HashSet<PassengerTicket>();
//    }
//
//    public static PassengerTicketRepositoryImpl getRepository(){
//        if (repository == null) {
//            repository = new PassengerTicketRepositoryImpl();
//        }
//        return repository;
//    }
//
//    @Override
//    public PassengerTicket create(PassengerTicket passengerTicket) {
//        boolean created = passengerTicketDB.add(passengerTicket);
//        if (!created){
//            return null;
//        }
//        return passengerTicket;
//    }
//    @Override
//    public PassengerTicket read(String passengerId, String ticketId) {
//        for(PassengerTicket passengerTicket : passengerTicketDB){
//            if(passengerTicket.getPassengerId().equals(passengerId) && passengerTicket.getTicketId().equals(ticketId)){
//                return passengerTicket;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public PassengerTicket update(PassengerTicket passengerTicket) {
//        PassengerTicket oldPassengerTicket = read(passengerTicket.getPassengerId(), passengerTicket.getTicketId());
//        if(oldPassengerTicket != null){
//            passengerTicketDB.remove(oldPassengerTicket);
//            passengerTicketDB.add(passengerTicket);
//            return passengerTicket;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String passengerId, String ticketId) {
//        PassengerTicket deletePassenger = read(passengerId, ticketId);
//        if(deletePassenger == null){
//            return false;
//        }
//        passengerTicketDB.remove(deletePassenger);
//        return true;
//    }
//
//    @Override
//    public Set<PassengerTicket> getAll() {
//        return passengerTicketDB;
//    }
//
//
//
//
//}
