//package za.ac.cput.groupx30.repository.impl;
//
//import za.ac.cput.groupx30.entity.Vehicle;
//import za.ac.cput.groupx30.repository.VehicleRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class VehicleRepositoryImpl implements VehicleRepository {
//    private static VehicleRepositoryImpl repository = null;
//    private Set<Vehicle> vehicleDB;
//
//    private VehicleRepositoryImpl() {
//        vehicleDB = new HashSet<>();
//    }
//
//    public static VehicleRepositoryImpl getRepository() {
//        if (repository == null)
//            repository = new VehicleRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public Vehicle create(Vehicle vehicle) {
//        this.vehicleDB.add(vehicle);
//        return vehicle;
//    }
//
//    @Override
//    public Vehicle read(String id) {
//        for (Vehicle route: vehicleDB) {
//            if (route.getId().equalsIgnoreCase(id))
//                return route;
//        }
//        return null;
//    }
//
//    @Override
//    public Vehicle update(Vehicle vehicle) {
//        Vehicle read = read(vehicle.getId());
//        if (read != null) {
//            this.vehicleDB.remove(read);
//            this.vehicleDB.add(vehicle);
//            return vehicle;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        Vehicle vehicle = read(id);
//        if (vehicle != null) {
//            this.vehicleDB.remove(id);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Vehicle> getAll() {
//        return vehicleDB;
//    }
//}
