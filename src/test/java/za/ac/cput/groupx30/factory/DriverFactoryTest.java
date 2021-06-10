package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: DriverFactoryTest
// Date: 11 June 2021

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Driver;

import static java.util.concurrent.TimeUnit.SECONDS;

class DriverFactoryTest {

    Driver driver = DriverFactory.createId("Thokozile");

    @Test
    void testEqualityId() {
        Assertions.assertEquals(driver, driver);
        Assertions.assertNotNull(driver);
        Assertions.assertNotNull(driver.getId());
    }

    @Test
    void testIdentityId(){
        Assertions.assertSame("Thokozile", "Thokozile");
    }

    @Test
    @org.junit.jupiter.api.Timeout(value = 1, unit = SECONDS)
    public void setId(){
        //while(true);
    }

    @Test
    @Disabled
    void setDriverId() {
    }
}