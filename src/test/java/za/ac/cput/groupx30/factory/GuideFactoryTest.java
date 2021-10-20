package za.ac.cput.groupx30.factory;

/* Thaakir Ajouhaar - 217244394
 * Guide Factory
 *  7 June 2021
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.groupx30.entity.Guide;

import static org.junit.jupiter.api.Assertions.*;

class GuideFactoryTest {
    @Test
    void createId() {
        Guide WeekdayGuide1 = GuideFactory.createId("Weekday Guide");
        Guide WeekendGuide1 = GuideFactory.createId("Weekend Guide");
        Guide WeekendGuide1Updated = new Guide.Builder().copy(WeekendGuide1).setName("Updated weekend guide").build();

        System.out.println(WeekdayGuide1);
        System.out.println(WeekendGuide1);
        System.out.println(WeekendGuide1Updated);
        assertNotEquals(WeekendGuide1, WeekendGuide1Updated);

    }

}