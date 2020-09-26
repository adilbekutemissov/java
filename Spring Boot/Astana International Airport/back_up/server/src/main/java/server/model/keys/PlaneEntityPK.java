package server.model.keys;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PlaneEntityPK implements Serializable {
    private int id;
    private int airlineId;

    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "airline_id", nullable = false)
    @Id
    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaneEntityPK that = (PlaneEntityPK) o;

        if (id != that.id) return false;
        if (airlineId != that.airlineId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + airlineId;
        return result;
    }
}
