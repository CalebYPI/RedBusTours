package za.ac.cput.groupx30.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.factory.RouteFactory;
import za.ac.cput.groupx30.repository.RouteRepository;
import za.ac.cput.groupx30.service.RouteService;

import java.util.HashSet;
import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {
    private static RouteServiceImpl service = null;

    @Autowired
    private RouteRepository repository;

    public static RouteServiceImpl getService() {
        if (service == null)
            service = new RouteServiceImpl();
        return service;
    }

    @Override
    public Route create(Route route) {
        return this.repository.save(route);
    }

    @Override
    public Route read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Route update(Route route) {
        if (this.repository.existsById(route.getId()))
            return this.repository.save(route);
        return null;
    }

    @Override
    public boolean delete(String id) {
        this.repository.deleteById(id);
        return !this.repository.existsById(id);
    }

    @Override
    public Set<Route> getAll() {
        return new HashSet<>(this.repository.findAll());
    }
}
