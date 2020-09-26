package server.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "airline", schema = "airbook", catalog = "ear2018zs_22")
public class AirlineEntity {
    private int id;
    private String name;
    private String email;
    private int phonenumber;
    private List<EmployeeEntity> employeesById;
    private List<FlightEntity> flightsById;
    private List<PlaneEntity> planesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phonenumber")
    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirlineEntity that = (AirlineEntity) o;
        return id == that.id &&
                phonenumber == that.phonenumber &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, phonenumber);
    }

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "airlineByAirlineid")
    public List<EmployeeEntity> getEmployeesById() {
        return employeesById;
    }

    public void setEmployeesById(List<EmployeeEntity> employeesById) {
        this.employeesById = employeesById;
    }

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "airlineByAirlineid")
    public List<FlightEntity> getFlightsById() {
        return flightsById;
    }

    public void setFlightsById(List<FlightEntity> flightsById) {
        this.flightsById = flightsById;
    }

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "airlineByAirlineid")
    public List<PlaneEntity> getPlanesById() {
        return planesById;
    }

    public void setPlanesById(List<PlaneEntity> planesById) {
        this.planesById = planesById;
    }
}
