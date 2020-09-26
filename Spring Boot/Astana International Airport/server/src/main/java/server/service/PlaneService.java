package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.dto.PlaneDto;
import server.model.PlaneEntity;
import server.repositories.PlaneRepository;
import server.service.Interfaces.PlaneServiceInterface;

import java.util.List;
import java.util.Optional;
@Service
public class PlaneService implements PlaneServiceInterface {

    @Autowired
    private final PlaneRepository repository;

    @Autowired
    public PlaneService(PlaneRepository repository) {
        this.repository = repository;
    }

    @Override
    public PlaneEntity create(PlaneDto planeDto) {
        return repository.saveAndFlush(planeDto.toEntity());
    }

    @Override
    public List<PlaneEntity> getAllPlane() {
        return repository.findAll();
    }

    @Override
    public Optional<PlaneEntity> getPlaneByID(int id) {
        return repository.findById(id);
    }

//    public Optional<PlaneEntity> getPlaneSeatsByID(int id) {
//        return repository.findById(id);
//    }

    @Override
    public void update(PlaneDto planeDto) {
        repository.saveAndFlush(planeDto.toEntity());
    }

    @Override
    public void delete(PlaneEntity plane) {
        repository.delete(plane);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}