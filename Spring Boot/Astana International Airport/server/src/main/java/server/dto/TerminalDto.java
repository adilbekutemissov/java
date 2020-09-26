package server.dto;

import org.modelmapper.ModelMapper;
import server.model.FlightEntity;
import server.model.TerminalEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

public class TerminalDto {

    @NotNull
    private int id;
    @NotNull
    private Integer flightid;
    @NotNull
    private List<FlightEntity> flightsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFlightid() {
        return flightid;
    }

    public void setFlightid(Integer flightid) {
        this.flightid = flightid;
    }

    public List<FlightEntity> getFlightsById() {
        return flightsById;
    }

    public void setFlightsById(List<FlightEntity> flightsById) {
        this.flightsById = flightsById;
    }

    public TerminalEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        TerminalEntity terminal = modelMapper.map(this, TerminalEntity.class);
        return terminal;
    }
}
