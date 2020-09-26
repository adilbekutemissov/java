package server.model.keys;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TerminalEntityPK implements Serializable {
    private int id;
    private int flightId;

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "flight_id", nullable = false)
    @Id
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

        TerminalEntityPK that = (TerminalEntityPK) o;

        if (id != that.id) return false;
        if (flightId != that.flightId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + flightId;
        return result;
    }
}
