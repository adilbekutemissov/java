package server.service;


import server.dto.PassengerDto;
import server.model.PassengerEntity;

import java.util.List;
import java.util.Optional;

public interface PassengerServiceInterface {

    PassengerEntity create(PassengerDto passengerDto);
    PassengerEntity save(PassengerEntity ticket);
    
    List<PassengerEntity> getAllPassengers();
    Optional<PassengerEntity> getPassengerByID(int id);

    void update(PassengerDto passengerDto);
    void updatePassengerNameById(Integer id, String newName);
    void updatePassengerSurnameById(Integer id, String newSurname);
    
    void delete(PassengerEntity ticket);

    void deleteById(int id);

    void updatePassengerEmailById(Integer id, String newEmail);

    void updatePassengerPasswordById(Integer id, String newPassword);
}
