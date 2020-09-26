package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.PassengerEntity;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Integer> {

}
