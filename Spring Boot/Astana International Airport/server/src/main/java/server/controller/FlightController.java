package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import server.dto.FlightDto;
import server.model.FlightEntity;
import server.service.FlightService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService service;

    public FlightController(FlightService service){
        this.service = service;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public FlightEntity create(@RequestBody FlightDto ticket){
        return service.create(ticket);
    }

    @RequestMapping(value="/getFlightById", method= RequestMethod.GET)
    public Optional<FlightEntity> getFlightById(@RequestParam("id") Integer id) {
        return service.getFlightByID(id);
    }

    @GetMapping(value="/getAllFlight")
    public List<FlightEntity> getAllFlight(){
        return service.getAllFlight();
    }

    @RequestMapping(value="/updatePlane/{id}", method= RequestMethod.PUT)
    public void updatePlane(@PathVariable Integer id, @RequestParam("price") Integer newPlane) {
        service.updatePlane(id, newPlane);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }
}
