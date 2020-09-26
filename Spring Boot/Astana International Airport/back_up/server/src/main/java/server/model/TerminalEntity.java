package server.model;

import server.model.keys.TerminalEntityPK;

import javax.persistence.*;

@Entity
@Table(name = "terminal", schema = "public", catalog = "ear2018zs_22")
@IdClass(TerminalEntityPK.class)
public class TerminalEntity {
    private int id;
    private int gate;
    private int flightId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gate", nullable = false)
    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    @Basic
    @Id
    @Column(name = "flight_id", nullable = false)
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TerminalEntity that = (TerminalEntity) o;

        if (id != that.id) return false;
        if (gate != that.gate) return false;
        if (flightId != that.flightId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + gate;
        result = 31 * result + flightId;
        return result;
    }
}
