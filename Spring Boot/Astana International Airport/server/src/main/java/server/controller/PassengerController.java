package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import server.dto.PassengerDto;
import server.model.PassengerEntity;
import server.service.PassengerService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService service;

    public PassengerController(PassengerService service){
        this.service = service;
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    public PassengerEntity create(@RequestBody PassengerDto passengerDto) {
        return service.create(passengerDto);
    }

    @GetMapping(value="/getPassengerById")
    public Optional<PassengerEntity> getPassengerById(@Validated @RequestParam("id") Integer id) {
        return service.getPassengerByID(id);
    }

    @GetMapping(value="/getAllPassengers")
    public List<PassengerEntity> getAllPassengers(){
        return service.getAllPassengers();
    }

    @RequestMapping(value="/updateName/{id}", method= RequestMethod.PUT)
    public void updateName(@PathVariable Integer id, @RequestParam("name") String newName) {
        service.updatePassengerNameById(id, newName);
    }

    @RequestMapping(value="/updateSurname/{id}", method= RequestMethod.PUT)
    public void updateSurname(@PathVariable Integer id, @RequestParam("surname") String newSurname) {
        service.updatePassengerSurnameById(id, newSurname);
    }

    @RequestMapping(value="/updateEmail/{id}", method= RequestMethod.PUT)
    public void updateEmail(@PathVariable Integer id, @RequestParam("email") String newEmail) {
        service.updatePassengerEmailById(id, newEmail);
    }

    @RequestMapping(value="/updatePassword/{id}", method= RequestMethod.PUT)
    public void updatePassword(@PathVariable Integer id, @RequestParam("password") String newPassword) {
        service.updatePassengerPasswordById(id, newPassword);
    }

//    @RequestMapping(value="/delete", method= RequestMethod.DELETE)
//    public void delete(@Validated @RequestParam("id") PassengerEntity passenger) {
//        service.delete(passenger);
//    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        service.deleteById(id);
    }
}
