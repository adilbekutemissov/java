package server.dto;

import org.modelmapper.ModelMapper;
import server.model.PassengerEntity;


import javax.validation.constraints.NotNull;

public class PassengerDto {
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private int phonenumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Integer getphonenumber() {
        return phonenumber;
    }

    public void setphonenumber(Integer phonenumber) {
        this.phonenumber = phonenumber;
    }

    public PassengerEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        PassengerEntity passenger = modelMapper.map(this, PassengerEntity.class);
        return passenger;
    }
}
