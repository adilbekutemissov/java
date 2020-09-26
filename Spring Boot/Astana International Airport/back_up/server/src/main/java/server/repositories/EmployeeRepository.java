package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
