package server.service.Interfaces;

import server.dto.PlaneSeatDto;
import server.model.PlaneseatEntity;
import server.model.PlaneseatEntityPK;

import java.util.List;
import java.util.Optional;

public interface PlaneSeatServiceInterface {
    PlaneseatEntity create(PlaneSeatDto planeSeatDto);

    List<PlaneseatEntity> getAllPlaneSeat();

    Optional<PlaneseatEntity> getPlaneSeatByID(Integer id);

    void update(PlaneSeatDto planeSeatDto);

    void delete(PlaneseatEntity plane);

    void deleteById(int id);
}
