package server.model.keys;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TicketEntityPK implements Serializable {
    private int id;
    private int passengerId;
    private int flightId;

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "passenger_id", nullable = false)
    @Id
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
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

        TicketEntityPK that = (TicketEntityPK) o;

        if (id != that.id) return false;
        if (passengerId != that.passengerId) return false;
        if (flightId != that.flightId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + passengerId;
        result = 31 * result + flightId;
        return result;
    }
}
