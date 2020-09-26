package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.model.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer> {
}
