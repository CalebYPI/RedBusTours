package za.ac.cput.groupx30.service.guide;

/*  GuideService.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 02 August 2021
 */


import za.ac.cput.groupx30.entity.Guide;

import java.util.Set;

public interface GuideService
{
    Guide create(Guide guide);
    Guide read(Guide.GuideId id);
    boolean delete(Guide guide);
    Set<Guide> getAll();
}
