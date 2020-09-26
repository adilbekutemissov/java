package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.model.AirlineEntity;

@Repository
public interface AirlineRepository extends JpaRepository<AirlineEntity, Integer> {
}
