//package za.ac.cput.groupx30.repository.location.impl;
//
///*
// LocationRepositoryImpl.java
// Repository Implementation for the Location
// Author: Caleb Ruiters (215169751)
// Date: 20 June 2021
//*/
//
//import za.ac.cput.groupx30.entity.Location;
//import za.ac.cput.groupx30.repository.location.LocationRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class LocationRepositoryImpl implements LocationRepository {
//    private static LocationRepositoryImpl repository = null;
//    private Set<Location> locationDB;
//
//    private LocationRepositoryImpl() {
//        this.locationDB = new HashSet<>();
//    }
//
//    public static LocationRepositoryImpl getRepository() {
//        if (repository == null) repository = new LocationRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public Location create(Location location) {
//        this.locationDB.add(location);
//        return location;
//    }
//
//    @Override
//    public Location read(String id) {
//        for (Location location: locationDB) {
//            if (location.getId().equalsIgnoreCase(id))
//                return location;
//        }
//        return null;
//    }
//
//    @Override
//    public Location update(Location location) {
//        Location read = read(location.getId());
//        if (read != null) {
//            this.locationDB.remove(read);
//            this.locationDB.add(location);
//            return location;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String id) {
//        Location location = read(id);
//        if (location != null) {
//            this.locationDB.remove(location);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Location> getAll() {
//        return locationDB;
//    }
//}
