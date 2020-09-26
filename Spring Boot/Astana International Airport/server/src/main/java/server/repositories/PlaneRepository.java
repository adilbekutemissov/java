package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.model.PlaneEntity;

@Repository
public interface PlaneRepository extends JpaRepository<PlaneEntity, Integer> {
}
