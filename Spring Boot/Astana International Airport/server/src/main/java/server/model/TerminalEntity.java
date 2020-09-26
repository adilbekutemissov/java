package server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "terminal", schema = "airbook", catalog = "ear2018zs_22")
public class TerminalEntity {
    private int id;
    private Integer flightid;
    private List<FlightEntity> flightsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "flightid")
    public Integer getFlightid() {
        return flightid;
    }

    public void setFlightid(Integer flightid) {
        this.flightid = flightid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerminalEntity that = (TerminalEntity) o;
        return id == that.id &&
                Objects.equals(flightid, that.flightid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, flightid);
    }

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "terminalByTerminalid")
    public List<FlightEntity> getFlightsById() {
        return flightsById;
    }

    public void setFlightsById(List<FlightEntity> flightsById) {
        this.flightsById = flightsById;
    }
}
