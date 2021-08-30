package za.ac.cput.groupx30.service.guide;

/*  GuideService.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 02 August 2021
 */


import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.service.IService;

import java.util.Set;

public interface GuideService extends IService<Guide, String>
{
    public Set<Guide> getAll();
}
