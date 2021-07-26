package za.ac.cput.groupx30.factory;
/**
 * Baron Mukenyi (217163742)
 * Test class factory for Driver Route
 * 11 June 2021
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.DriverRoute;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

class DriverRouteFactoryTest {
    DriverRoute driverRoute = DriverRouteFactory.createRoute("N1");

    @Test
    public void testRouteEqualityID(){
        Assertions.assertEquals(driverRoute, driverRoute);
        Assertions.assertNotNull(driverRoute);
        Assertions.assertNotNull(driverRoute.getRouteID());
    }

    @Test
    public void testRouteIdentity(){
        Assertions.assertSame("N1", "N1");
    }


    @Test
    @org.junit.jupiter.api.Timeout(value = 1, unit = SECONDS)
    public void setRoute(){

    }

    @Test
    @Disabled
    public void setDriverRouteID(){

    }

}