package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import server.dto.PlaneSeatDto;
import server.model.PlaneseatEntity;
import server.repositories.PlaneSeatRepository;
import server.service.Interfaces.PlaneSeatServiceInterface;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaneSeatService implements PlaneSeatServiceInterface {

    @Autowired
    private final PlaneSeatRepository repository;

    @Autowired
    public PlaneSeatService(PlaneSeatRepository repository) {
        this.repository = repository;
    }

    @Override
    public PlaneseatEntity create(PlaneSeatDto planeSeatDto) {
        return repository.saveAndFlush(planeSeatDto.toEntity());
    }

    @Override
    public List<PlaneseatEntity> getAllPlaneSeat() {

        return repository.findAll();
    }

    @Override
    public Optional<PlaneseatEntity> getPlaneSeatByID(Integer id) {
        return Optional.empty();
    }


    public List<PlaneseatEntity> getPlaneSeatByID(Integer planeid, Integer number) {
        return repository.findAll().stream().filter(p -> p.getNumber()== number && p.getPlaneid() == planeid)
                .collect(Collectors.toList());
    }

    public void updateFree(Integer number, Integer planeid, boolean newFree) {
        PlaneseatEntity planeSeat = repository.findPlaneseatEntitiesByNumberAndPlaneid(number, planeid);
        planeSeat.setFree(newFree);
        repository.saveAndFlush(planeSeat);
    }




    @Override
    public void update(PlaneSeatDto planeSeatDto) {
        repository.saveAndFlush(planeSeatDto.toEntity());
    }

    public void updatePlaneSeatById(Integer planeid, boolean newFree) {
        PlaneseatEntity planeSeat = repository.findById(planeid).orElseThrow(() -> new ResourceNotFoundException(planeid.toString()));
        planeSeat.setFree(newFree);
        repository.saveAndFlush(planeSeat);
    }

    @Override
    public void delete(PlaneseatEntity plane) {
        repository.delete(plane);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
