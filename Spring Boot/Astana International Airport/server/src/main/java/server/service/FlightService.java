package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import server.dto.FlightDto;
import server.model.FlightEntity;
import server.repositories.FlightRepository;
import server.service.Interfaces.FlightServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService implements FlightServiceInterface {

    @Autowired
    private FlightRepository repository;

    @Autowired
    public FlightService(FlightRepository repository) {
        this.repository = repository;
    }

    public FlightService() {
    }

    @Override
    public FlightEntity create(FlightDto flightDto) {
        return repository.saveAndFlush(flightDto.toEntity());
    }

    @Override
    public List<FlightEntity> getAllFlight() {
        return repository.findAll();
    }

    @Override
    public Optional<FlightEntity> getFlightByID(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(FlightDto flightDto) {
        repository.saveAndFlush(flightDto.toEntity());
    }

    public void updatePlane(Integer id, Integer newPlane){
        FlightEntity passenger = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        passenger.setPlaneid(newPlane);
        repository.saveAndFlush(passenger);
    }

    @Override
    public void delete(FlightEntity flight) {
        repository.saveAndFlush(flight);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}