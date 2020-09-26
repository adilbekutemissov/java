package server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.model.PassengerEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/BookTicketController")
public class BookTicketController {

    private PassengerController passengerController;
    private TicketController ticketController;
    private FlightController flightController;
    private PlaneseatController planeseatController;



    public BookTicketController(PassengerController passengerController, TicketController ticketController, FlightController flightController, PlaneseatController planeseatController) {
        this.passengerController = passengerController;
        this.ticketController = ticketController;
        this.flightController = flightController;
        this.planeseatController = planeseatController;
    }



    @GetMapping(value="/getAllPlaneseats")
    public List<PassengerEntity> getAllPlaneseats(){
        return this.passengerController.getAllPassengers();
    }

}
