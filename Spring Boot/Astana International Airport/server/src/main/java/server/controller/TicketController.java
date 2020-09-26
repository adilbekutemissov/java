package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import server.dto.TicketDto;
import server.model.TicketEntity;
import server.service.TicketService;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService service;

    public TicketController(TicketService service){
        this.service = service;
    }

    public TicketController() {
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public TicketEntity create(@RequestBody TicketDto ticket){
        return service.create(ticket);
    }

    @GetMapping(value="/getTicketById")
    public Optional<TicketEntity> getTicketById(@Validated @RequestParam("id") Integer id) {
        return service.getTicketByID(id);
    }

    @GetMapping(value="/getAllTicket")
    public List<TicketEntity> getAllTicket(){
        System.out.println();
        return service.getAllTicket();
    }

    @RequestMapping(value="/updatePassword/{id}", method= RequestMethod.PUT)
    public void updatePrice(@PathVariable Integer id, @RequestParam("price") BigInteger newPrice) {
        service.updateTicketPriceById(id, newPrice);
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
