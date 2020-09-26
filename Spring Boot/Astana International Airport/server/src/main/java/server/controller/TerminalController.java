package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import server.dto.TerminalDto;
import server.model.TerminalEntity;
import server.service.TerminalService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/terminal")
public class TerminalController {

    @Autowired
    private TerminalService service;

    public TerminalController(TerminalService service){
        this.service = service;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public TerminalEntity create(@RequestBody TerminalDto terminal){
        return service.create(terminal);
    }

    @RequestMapping(value="/getTerminalById", method= RequestMethod.GET)
    public Optional<TerminalEntity> getAirlineById(@RequestParam("id") Integer id) {
        return service.getTerminalByID(id);
    }


    @GetMapping(value="/getAllTerminal")
    public List<TerminalEntity> getAllAirline(){
        return service.getAllTerminal();
    }

    @RequestMapping(value="/updateFlight/{id}", method= RequestMethod.PUT)
    public void updateFlight(@PathVariable Integer id, @RequestParam("price") Integer newFlight) {
        service.updateFlight(id, newFlight);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }
}
