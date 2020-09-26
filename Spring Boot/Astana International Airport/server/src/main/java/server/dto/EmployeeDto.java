package server.dto;

import org.modelmapper.ModelMapper;
import server.model.EmployeeEntity;

import javax.validation.constraints.NotNull;

public class EmployeeDto {
    @NotNull
    private int id;
    @NotNull
    private int airlineid;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private int phonenumber;
//    @NotNull
//    private AirlineEntity airlineByAirlineid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(int airlineid) {
        this.airlineid = airlineid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

//    public AirlineEntity getAirlineByAirlineid() {
//        return airlineByAirlineid;
//    }
//
//    public void setAirlineByAirlineid(AirlineEntity airlineByAirlineid) {
//        this.airlineByAirlineid = airlineByAirlineid;
//    }

    public EmployeeEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        EmployeeEntity employee = modelMapper.map(this, EmployeeEntity.class);
        return employee;
    }
}
