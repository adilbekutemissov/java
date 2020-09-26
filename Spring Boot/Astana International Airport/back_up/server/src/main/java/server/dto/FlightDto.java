package server.dto;

import org.modelmapper.ModelMapper;
import server.model.FlightEntity;
import server.model.PassengerEntity;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class FlightDto {

    @NotNull
    private int id;
    @NotNull
    private int planeId;
    @NotNull
    private int airlineId;
    @NotNull
    private Timestamp departmentDate;
    @NotNull
    private Timestamp arrivalsDate;
    @NotNull
    private String arrival;
    @NotNull
    private String department;
    @NotNull
    private int distance;
    @NotNull
    private int seatsCapacity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public Timestamp getDepartmentDate() {
        return departmentDate;
    }

    public void setDepartmentDate(Timestamp departmentDate) {
        this.departmentDate = departmentDate;
    }

    public Timestamp getArrivalsDate() {
        return arrivalsDate;
    }

    public void setArrivalsDate(Timestamp arrivalsDate) {
        this.arrivalsDate = arrivalsDate;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(int seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }


    public FlightEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        FlightEntity flightEntity = modelMapper.map(this, FlightEntity.class);
        return flightEntity;
    }
}
