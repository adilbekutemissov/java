package server.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import server.model.FlightEntity;
import server.model.PassengerEntity;
import server.model.TicketEntity;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Service
public class TicketDto {
    @NotNull
    private int id;
    @NotNull
    private int passengerid;
    @NotNull
    private int flightid;
    @NotNull
    private BigInteger price;
    @NotNull
    private Integer seatnumber;

//    @NotNull
//    private PassengerEntity passengerByPassengerid;
//    @NotNull
//    private FlightEntity flightByFlightid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(int passengerid) {
        this.passengerid = passengerid;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public Integer getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(Integer seatnumber) {
        this.seatnumber = seatnumber;
    }

//    public PassengerEntity getPassengerByPassengerid() {
//        return passengerByPassengerid;
//    }
//
//    public void setPassengerByPassengerid(PassengerEntity passengerByPassengerid) {
//        this.passengerByPassengerid = passengerByPassengerid;
//    }
//
//    public FlightEntity getFlightByFlightid() {
//        return flightByFlightid;
//    }
//
//    public void setFlightByFlightid(FlightEntity flightByFlightid) {
//        this.flightByFlightid = flightByFlightid;
//    }

    public TicketEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        TicketEntity ticket = modelMapper.map(this, TicketEntity.class);
        return ticket;
    }
}
