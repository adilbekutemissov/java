package server.service.Interfaces;

import server.dto.AirlineDto;
import server.model.AirlineEntity;

import java.util.List;
import java.util.Optional;

public interface AirlineServiceInterface {

    AirlineEntity create(AirlineDto airlineDto);

    List<AirlineEntity> getAllAirline();
    Optional<AirlineEntity> getAirlineByID(int id);

    void update(AirlineDto airlineDto);
    void delete(AirlineEntity airline);
    void deleteById(int id);
}
