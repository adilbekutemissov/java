package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import server.dto.AirlineDto;
import server.model.AirlineEntity;
import server.repositories.AirlineRepository;
import server.service.Interfaces.AirlineServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService implements AirlineServiceInterface {

    @Autowired
    private final AirlineRepository repository;

    @Autowired
    public AirlineService(AirlineRepository repository) {
        this.repository = repository;
    }

    @Override
    public AirlineEntity create(AirlineDto airlineDto) {
        return repository.saveAndFlush(airlineDto.toEntity());
    }

    @Override
    public List<AirlineEntity> getAllAirline() {
        return repository.findAll();
    }

    @Override
    public Optional<AirlineEntity> getAirlineByID(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(AirlineDto airlineDto) {
        repository.saveAndFlush(airlineDto.toEntity());
    }

    public void updateName(Integer id, String newName){
        AirlineEntity airline = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        airline.setName(newName);
        repository.saveAndFlush(airline);
    }

    @Override
    public void delete(AirlineEntity airline) {
        repository.delete(airline);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
