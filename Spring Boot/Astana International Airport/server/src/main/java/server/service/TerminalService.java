package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import server.dto.TerminalDto;
import server.model.TerminalEntity;
import server.repositories.TerminalRepository;
import server.service.Interfaces.TerminalServiceInterface;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalService implements TerminalServiceInterface {

    private final TerminalRepository repository;

    @Autowired
    public TerminalService(TerminalRepository repository) {
        this.repository = repository;
    }

    @Override
    public TerminalEntity create(TerminalDto terminalDto) {
        return repository.saveAndFlush(terminalDto.toEntity());
    }

    @Override
    public List<TerminalEntity> getAllTerminal() {
        return repository.findAll();
    }

    @Override
    public Optional<TerminalEntity> getTerminalByID(int id) {
        return repository.findById(id);
    }

    @Override
    public TerminalEntity update(TerminalDto terminalDto) {
        return repository.saveAndFlush(terminalDto.toEntity());
    }

    public void updateFlight(Integer id, Integer newFlight) {
        TerminalEntity terminal = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        terminal.setFlightid(newFlight);
        repository.saveAndFlush(terminal);
    }

    @Override
    public void delete(TerminalEntity terminal) {
        repository.delete(terminal);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
