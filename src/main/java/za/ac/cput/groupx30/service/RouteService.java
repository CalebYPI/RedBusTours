package za.ac.cput.groupx30.service;

import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface RouteService extends IService<Route, String> {
    Set<Route> getAll();
}
