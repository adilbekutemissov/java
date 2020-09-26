package server.service;

import org.springframework.data.jpa.repository.JpaRepository;
import server.dto.PassengerDto;
import server.dto.TicketDto;
import server.model.PassengerEntity;
import server.model.TicketEntity;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface TicketServiceInterface{
    TicketEntity create(TicketDto ticketDto);
    TicketEntity save(TicketEntity ticket);

    List<TicketEntity> getAllTicket();
    Optional<TicketEntity> getTicketByID(int id);

    void update(TicketDto ticketDto);
    void updateTicketPriceById(Integer id, BigInteger newPrice);

    void delete(TicketEntity ticket);
    void deleteById(int id);
}
