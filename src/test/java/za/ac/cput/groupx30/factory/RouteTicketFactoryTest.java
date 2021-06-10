package za.ac.cput.groupx30.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.RouteTicket;

import static org.junit.jupiter.api.Assertions.*;

class RouteTicketFactoryTest {
    RouteTicket routeTicket = RouteTicketFactory.createTicker("Robben Island");

    @Test
    public void testRouteTicketEqaulity(){
        Assertions.assertEquals(routeTicket, routeTicket);
        Assertions.assertNotNull(routeTicket);
        Assertions.assertNotNull(routeTicket.getRouteDesc());
    }

    @Test
    public void testTicketIdentity(){
        Assertions.assertSame("Robben Island", "Robben Island");
    }

//    @Test
//    @org.junit.jupiter.api.Timeout(value = 1, unit = SECONDS);
//    public void setTicket(){
//
//    }

    @Test
    @Disabled
    public void setRouteTicket(){

    }

}