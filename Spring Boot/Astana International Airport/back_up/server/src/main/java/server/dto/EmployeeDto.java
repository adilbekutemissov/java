package server.dto;

import org.modelmapper.ModelMapper;
import server.model.EmployeeEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class EmployeeDto {
    @NotNull
    private int id;

    @NotNull
    private String company_name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private int phone_number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
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

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public EmployeeEntity toEntity(){
        ModelMapper modelMapper = new ModelMapper();
        EmployeeEntity employee = modelMapper.map(this, EmployeeEntity.class);
        return employee;
    }
}
