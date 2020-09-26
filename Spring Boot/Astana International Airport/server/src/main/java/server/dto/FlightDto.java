package server.dto;

import org.modelmapper.ModelMapper;
import server.model.FlightEntity;
import server.model.TicketEntity;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

public class FlightDto {
    @NotNull
    private int id;
    @NotNull
    private int planeid;
    @NotNull
    private int airlineid;
    @NotNull
    private Timestamp departmentdate;
    @NotNull
    private Timestamp arrilvalsdate;
    @NotNull
    private String department;
    @NotNull
    private String arrival;
    @NotNull
    private int distance;
    @NotNull
    private int terminalid;
//    @NotNull
//    private AirlineEntity airlineByAirlineid;
//    @NotNull
//    private TerminalEntity terminalByTerminalid;
    @NotNull
    private List<TicketEntity> ticketsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaneid() {
        return planeid;
    }

    public void setPlaneid(int planeid) {
        this.planeid = planeid;
    }

    public int getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(int airlineid) {
        this.airlineid = airlineid;
    }

    public Timestamp getDepartmentdate() {
        return departmentdate;
    }

    public void setDepartmentdate(Timestamp departmentdate) {
        this.departmentdate = departmentdate;
    }

    public Timestamp getArrilvalsdate() {
        return arrilvalsdate;
    }

    public void setArrilvalsdate(Timestamp arrilvalsdate) {
        this.arrilvalsdate = arrilvalsdate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(int terminalid) {
        this.terminalid = terminalid;
    }

//    public AirlineEntity getAirlineByAirlineid() {
//        return airlineByAirlineid;
//    }
//
//    public void setAirlineByAirlineid(AirlineEntity airlineByAirlineid) {
//        this.airlineByAirlineid = airlineByAirlineid;
//    }
//
//    public TerminalEntity getTerminalByTerminalid() {
//        return terminalByTerminalid;
//    }
//
//    public void setTerminalByTerminalid(TerminalEntity terminalByTerminalid) {
//        this.terminalByTerminalid = terminalByTerminalid;
//    }

    public List<TicketEntity> getTicketsById() {
        return ticketsById;
    }

    public void setTicketsById(List<TicketEntity> ticketsById) {
        this.ticketsById = ticketsById;
    }

    public FlightEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        FlightEntity flightEntity = modelMapper.map(this, FlightEntity.class);
        return flightEntity;
    }
}
