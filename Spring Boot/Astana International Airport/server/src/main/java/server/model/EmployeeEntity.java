package server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "airbook", catalog = "ear2018zs_22")
public class EmployeeEntity {
    private int id;
    private int airlineid;
    private String email;
    private String password;
    private int phonenumber;
    private AirlineEntity airlineByAirlineid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "airlineid")
    public int getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(int airlineid) {
        this.airlineid = airlineid;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        EmployeeEntity that = (EmployeeEntity) o;
        return id == that.id &&
                airlineid == that.airlineid &&
                phonenumber == that.phonenumber &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, airlineid, email, password, phonenumber);
    }

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "airlineid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public AirlineEntity getAirlineByAirlineid() {
        return airlineByAirlineid;
    }

    public void setAirlineByAirlineid(AirlineEntity airlineByAirlineid) {
        this.airlineByAirlineid = airlineByAirlineid;
    }
}
