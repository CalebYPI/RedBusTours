package za.ac.cput.groupx30.factory;

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