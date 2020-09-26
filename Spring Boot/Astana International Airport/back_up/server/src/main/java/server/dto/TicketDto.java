package server.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import server.model.TicketEntity;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Service
public class TicketDto {
    @NotNull
    private Integer id;

    @NotNull
    private Integer passenger_id;

    @NotNull
    private Integer flight_id;

    @NotNull
    private BigInteger price;

    @NotNull
    private int seat_number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassanger_id() {
        return passenger_id;
    }

    public void setPassanger_id(Integer passanger_id) {
        this.passenger_id = passanger_id;
    }

    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public TicketEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        TicketEntity ticket = modelMapper.map(this, TicketEntity.class);
        return ticket;
    }
}
