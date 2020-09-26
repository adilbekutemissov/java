package server.service.Interfaces;

import server.dto.PlaneDto;
import server.model.PlaneEntity;

import java.util.List;
import java.util.Optional;

public interface PlaneServiceInterface {

    PlaneEntity create(PlaneDto planeDto);

    List<PlaneEntity> getAllPlane();
    Optional<PlaneEntity> getPlaneByID(int id);

    void update(PlaneDto planeDto);

    void delete(PlaneEntity plane);

    void deleteById(int id);

}
