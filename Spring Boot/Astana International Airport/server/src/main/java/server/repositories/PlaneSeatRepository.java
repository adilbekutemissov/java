package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.model.PlaneseatEntity;

import java.util.List;

@Repository
public interface PlaneSeatRepository extends JpaRepository<PlaneseatEntity, Integer> {

    List<PlaneseatEntity> findAllNumberByPlaneidOrderByNumberAsc(@Param("planeid") Integer planeid);

    PlaneseatEntity findPlaneseatEntitiesByNumberAndPlaneid(@Param("number") Integer number, @Param("planeid") Integer planeid);
}
