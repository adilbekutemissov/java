package server.dto;

import org.modelmapper.ModelMapper;
import server.model.AirlineEntity;

import javax.validation.constraints.NotNull;

public class AirlineDto {
    @NotNull
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private int phonenumber;
//    @NotNull
//    private Collection<EmployeeEntity> employeesById;
//    @NotNull
//    private Collection<FlightEntity> flightsById;
//    @NotNull
//    private Collection<PlaneEntity> planesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

//    public Collection<EmployeeEntity> getEmployeesById() {
//        return employeesById;
//    }
//
//    public void setEmployeesById(Collection<EmployeeEntity> employeesById) {
//        this.employeesById = employeesById;
//    }
//
//    public Collection<FlightEntity> getFlightsById() {
//        return flightsById;
//    }
//
//    public void setFlightsById(Collection<FlightEntity> flightsById) {
//        this.flightsById = flightsById;
//    }
//
//    public Collection<PlaneEntity> getPlanesById() {
//        return planesById;
//    }
//
//    public void setPlanesById(Collection<PlaneEntity> planesById) {
//        this.planesById = planesById;
//    }

    public AirlineEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        AirlineEntity airline = modelMapper.map(this, AirlineEntity.class);
        return airline;
    }
}
