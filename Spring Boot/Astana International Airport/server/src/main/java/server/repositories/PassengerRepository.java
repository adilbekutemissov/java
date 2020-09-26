package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.model.PassengerEntity;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Integer> {
    PassengerEntity findOneByName(String name);

}
