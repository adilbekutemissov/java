package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.model.TicketEntity;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    TicketEntity findOneById(int id);

//    TicketEntity findByPassanger(PassengerEntity p);

}
