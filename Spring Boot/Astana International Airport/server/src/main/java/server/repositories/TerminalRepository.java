package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.model.TerminalEntity;

@Repository
public interface TerminalRepository extends JpaRepository<TerminalEntity, Integer> {
}
