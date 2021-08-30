//package za.ac.cput.groupx30.repository.routeTicket.imp;
//
//import za.ac.cput.groupx30.entity.RouteTicket;
//import za.ac.cput.groupx30.repository.RouteTicketRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class RouteTicketImpl implements RouteTicketRepository {
//    private static RouteTicketImpl repository = null;
//    private Set<RouteTicket> routeTicketDB;
//
//    private RouteTicketImpl(){
//        routeTicketDB = new HashSet<>();
//    }
//
//    public static RouteTicketImpl getRepository(){
//        if(repository == null)
//            repository = new RouteTicketImpl();
//            return repository;
//    }
//    @Override
//    public RouteTicket create(RouteTicket routeTicket) {
//        boolean createRouteTicket = routeTicketDB.add(routeTicket);
//        if(!createRouteTicket){
//            return null;
//        }
//        return routeTicket;
//    }
//
//    @Override
//    public RouteTicket read(String route) {
//        for(RouteTicket rT : routeTicketDB){
//            if(rT.getRoute().equals(routeTicketDB)){
//                return rT;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public RouteTicket update(RouteTicket routeTicket) {
//        RouteTicket previousRoute = read(routeTicket.getRouteDesc());
//        if(previousRoute != null){
//            routeTicketDB.remove(previousRoute);
//            routeTicketDB.add(routeTicket);
//            return routeTicket;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String routeDesc) {
//        RouteTicket removeTicketRoute = read(routeDesc);
//        if(removeTicketRoute == null){
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public Set<RouteTicket> getAll() {
//        return routeTicketDB;
//    }
//}
