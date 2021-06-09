package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: DriverFactoryTest
// Date: 11 June 2021

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Driver;
import org.junit.jupiter.api.Assertions;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

class DriverFactoryTest {

    @Test
    void createId() {
        Driver driver = DriverFactory.createId("Thokozile");
        Assertions.assertEquals(driver, driver);
        Assertions.assertSame("Thokozile", "Thokozile");
        Assertions.assertNotNull(driver);
        Assertions.assertNotNull(driver.getId());
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.Timeout(value = 1000, unit = NANOSECONDS)
    public void setId() {
    }

    @Test
    @Disabled
    @DisplayName("TDD method should not run")
    public void testDisable() {
        org.junit.jupiter.api.Assertions.fail("This test should be disabled");
    }
}