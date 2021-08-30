//package za.ac.cput.groupx30.repository.impl;
//
//// Author: Thokozile Snono
//// Student number: 216032121
//// Entity: DriverVehicleRepositoryImpl
//// Date: 26 July 2021
//
//import za.ac.cput.groupx30.entity.DriverVehicle;
//import za.ac.cput.groupx30.repository.DriverVehicleRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class DriverVehicleRepositoryImpl implements DriverVehicleRepository {
//    private static DriverVehicleRepository repository = null;
//    private Set< DriverVehicle > driverVehicleDB;
//
//    private DriverVehicleRepositoryImpl() { this.driverVehicleDB = new HashSet<>();}
//
//    public static DriverVehicleRepository getRepository() {
//        if (repository == null) repository = new DriverVehicleRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public Set< DriverVehicle > getAll() {
//        return driverVehicleDB;
//    }
//
//    @Override
//    public DriverVehicle create(DriverVehicle driverVehicle) {
//        this.driverVehicleDB.add(driverVehicle);
//        return driverVehicle;
//    }
//
//    @Override
//    public DriverVehicle read(String vehicleID) {
//        for (DriverVehicle driverVehicle: driverVehicleDB) {
//            if (driverVehicle.getVehicleId().equalsIgnoreCase(vehicleID))
//                return driverVehicle;
//        }
//        return null;
//    }
//
//    @Override
//    public DriverVehicle update(DriverVehicle driverVehicle) {
//        DriverVehicle read = read(driverVehicle.getVehicleId());
//        if (read != null) {
//            this.driverVehicleDB.remove(read);
//            this.driverVehicleDB.add(driverVehicle);
//            return driverVehicle;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String driverVehicleID) {
//        DriverVehicle driverVehicle = read(driverVehicleID);
//        if (driverVehicle != null) {
//            this.driverVehicleDB.remove(driverVehicleID);
//            return true;
//        }
//        return false;
//    }
//}
