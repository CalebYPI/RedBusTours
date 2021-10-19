package za.ac.cput.groupx30.repository;

/**
 * Author: Shaheed_Cloete(213239442)
 * Desc: Repository Interface for PassengerTicket
 * Date: 24 July 2021
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.groupx30.entity.PassengerTicket;
import za.ac.cput.groupx30.repository.IRepository;

import java.util.Set;

@Repository
public interface PassengerTicketRepository extends JpaRepository<PassengerTicket, PassengerTicket.PassengerTicketId> {

}
