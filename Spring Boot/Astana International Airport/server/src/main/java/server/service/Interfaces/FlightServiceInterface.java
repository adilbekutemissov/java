package server.service.Interfaces;

import server.dto.FlightDto;
import server.model.FlightEntity;

import java.util.List;
import java.util.Optional;

public interface FlightServiceInterface {

    FlightEntity create(FlightDto flightDto);

    List<FlightEntity> getAllFlight();
    Optional<FlightEntity> getFlightByID(int id);

    void update(FlightDto flightDto);

    void delete(FlightEntity flight);

    void deleteById(int id);
}
