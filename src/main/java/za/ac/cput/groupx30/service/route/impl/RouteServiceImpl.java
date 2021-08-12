package za.ac.cput.groupx30.service.route.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.groupx30.entity.Route;
import za.ac.cput.groupx30.repository.route.RouteRepository;
import za.ac.cput.groupx30.repository.route.impl.RouteRepositoryImpl;
import za.ac.cput.groupx30.service.route.RouteService;

import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteRepository repository = null;
    private static RouteServiceImpl service = null;

    private RouteServiceImpl() {
        this.repository = RouteRepositoryImpl.getRepository();
    }

    public static RouteServiceImpl getService() {
        if (service == null)
            service = new RouteServiceImpl();
        return service;
    }

    @Override
    public Route create(Route route) {
        return this.repository.create(route);
    }

    @Override
    public Route read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Route update(Route route) {
        return this.repository.update(route);
    }

    @Override
    public boolean delete(String id) {
        return this.repository.delete(id);
    }

    @Override
    public Set<Route> getAll() {
        return this.repository.getAll();
    }
}
