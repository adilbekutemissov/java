package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import server.dto.TicketDto;
import server.model.TicketEntity;
import server.repositories.TicketRepository;
import server.service.Interfaces.TicketServiceInterface;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements TicketServiceInterface {

    private TicketRepository repository;

    public TicketService() {
    }

    @Autowired
    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public TicketEntity create(TicketDto ticketDto) {
        return repository.saveAndFlush(ticketDto.toEntity());
    }

    @Override
    public TicketEntity save(TicketEntity ticket) {
        return repository.saveAndFlush(ticket);
    }

    @Override
    public List<TicketEntity> getAllTicket() {
        return repository.findAll();
    }

    @Override
    public Optional<TicketEntity> getTicketByID(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(TicketDto ticketDto) {
        repository.saveAndFlush(ticketDto.toEntity());
    }

    @Override
    public void updateTicketPriceById(Integer id, BigInteger newPrice) {
        TicketEntity passenger = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        passenger.setPrice(newPrice);
        repository.saveAndFlush(passenger);
    }

    @Override
    public void delete(TicketEntity ticket) {
        repository.delete(ticket);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
