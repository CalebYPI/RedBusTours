package za.ac.cput.groupx30.factory;

/* Thaakir Ajouhaar - 217244394
 * Guide Factory
 *  7 June 2021
 */

import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.util.Helper;

public class GuideFactory {

    public static Guide createId(String name) {

        String id = Helper.generateId();
        Guide guide = new Guide.Builder()
                .setId(id)
                .setName(name)
                .build();

        return guide;
    }
}
