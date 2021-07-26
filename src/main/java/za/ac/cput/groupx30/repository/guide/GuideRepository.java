package za.ac.cput.groupx30.repository.guide;

/*  GuideRepository.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 26 July 2021
 */

import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

public interface GuideRepository extends IRepository<Guide, String>
{
    Set<Guide> getAll();
}