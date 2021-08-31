package za.ac.cput.groupx30.repository;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Repository Interface for Ticket
 * Date: 24 July 2021
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.Ticket;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    //public Set<Ticket> getAll();
}
