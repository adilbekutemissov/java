package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import server.dto.PassengerDto;
import server.model.PassengerEntity;
import server.repositories.PassengerRepository;
import server.service.Interfaces.PassengerServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService implements PassengerServiceInterface {
    public PassengerService() {
    }

    @Autowired
    private PassengerRepository repository;

    @Autowired
    public PassengerService(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public PassengerEntity create(PassengerDto passengerDto) {
        return repository.saveAndFlush(passengerDto.toEntity());
    }

    @Override
    public PassengerEntity save(PassengerEntity passenger) {
        return repository.saveAndFlush(passenger);
    }

    @Override
    public List<PassengerEntity> getAllPassengers() {
        return repository.findAll();
    }

    @Override
    public Optional<PassengerEntity> getPassengerByID(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(PassengerDto passengerDto) {
        repository.saveAndFlush(passengerDto.toEntity());
    }

    @Override
    public void updatePassengerNameById(Integer id, String newName) {
        PassengerEntity passenger = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        passenger.setSurname(newName);
        repository.saveAndFlush(passenger);
    }

    @Override
    public void updatePassengerSurnameById(Integer id, String newSurname) {
        PassengerEntity passenger = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        passenger.setSurname(newSurname);
        repository.saveAndFlush(passenger);
    }

    @Override
    public void updatePassengerEmailById(Integer id, String newEmail) {
        PassengerEntity passenger = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        passenger.setEmail(newEmail);
        repository.saveAndFlush(passenger);
    }

    @Override
    public void updatePassengerPasswordById(Integer id, String newPassword) {
        PassengerEntity passenger = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        passenger.setPassword(newPassword);
        repository.saveAndFlush(passenger);
    }

    @Override
    public void delete(PassengerEntity passenger) {
        repository.delete(passenger);
    }

    @Override
    public void deleteById(int id){
        repository.deleteById(id);
    }
}