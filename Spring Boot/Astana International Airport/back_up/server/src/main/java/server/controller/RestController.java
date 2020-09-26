package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import server.model.PassengerEntity;
import server.repositories.TicketRepository;
import server.service.PassengerService;

import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    PassengerService service;

    @GetMapping("hello")
    public void hello(){
        System.out.println();
    }

//    @GetMapping("passengers")
//    public List<PassengerEntity> passengers(){
//        return service.getAllPassengers();
//    }
//
//    @GetMapping(value="/getPassengerById")
//    public Optional<PassengerEntity> get(@Validated @RequestParam("id") Integer id) {
//        return service.getPassengerByID(id);
//    }


}
