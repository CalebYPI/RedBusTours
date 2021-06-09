package za.ac.cput.groupx30.factory;

// Author: Thokozile Snono
// Entity: DriverFactoryTest
// Date: 11 June 2021

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Driver;
import org.junit.jupiter.api.Assertions;

class DriverFactoryTest {

    @Test
    void createId() {
        Driver driver = DriverFactory.createId("Thokozile");
        //Assertions.assertEquals(driver, driver);
        Assertions.assertNotNull(driver);
        Assertions.assertNotNull(driver.getId());
    }
}