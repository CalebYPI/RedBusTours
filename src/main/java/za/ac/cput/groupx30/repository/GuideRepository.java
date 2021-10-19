package za.ac.cput.groupx30.repository;

/*  GuideRepository.java
 *  Author: Thaakir Ajouhaar (217244394)
 *  Date: 26 July 2021
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.Guide;
import za.ac.cput.groupx30.entity.RouteGuide;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.List;
import java.util.Set;

@Repository
public interface GuideRepository extends JpaRepository<Guide, String> {
    //List<Guide> findAllById(String id);
    //List<Guide> findAllByName(String name);
}