package server.service.Interfaces;

import server.dto.TerminalDto;
import server.model.TerminalEntity;

import java.util.List;
import java.util.Optional;

public interface TerminalServiceInterface {

    TerminalEntity create(TerminalDto terminalDto);

    List<TerminalEntity> getAllTerminal();
    Optional<TerminalEntity> getTerminalByID(int id);

    TerminalEntity update(TerminalDto terminalDto);
    void delete(TerminalEntity terminal);
    void deleteById(int id);
}
