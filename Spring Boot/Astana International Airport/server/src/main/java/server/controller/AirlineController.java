package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import server.dto.AirlineDto;
import server.model.AirlineEntity;
import server.service.AirlineService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService service;

    public AirlineController(AirlineService service){
        this.service = service;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public AirlineEntity create(@RequestBody AirlineDto airline){
        return service.create(airline);
    }

    @RequestMapping(value="/getAirlineById", method= RequestMethod.GET)
    public Optional<AirlineEntity> getAirlineById(@RequestParam("id") Integer id) {
        return service.getAirlineByID(id);
    }


    @GetMapping(value="/getAllAirline")
    public List<AirlineEntity> getAllAirline(){
        return service.getAllAirline();
    }

    @RequestMapping(value="/updateName/{id}", method= RequestMethod.PUT)
    public void updateName(@PathVariable Integer id, @RequestParam("price") String newName) {
        service.updateName(id, newName);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }
}
