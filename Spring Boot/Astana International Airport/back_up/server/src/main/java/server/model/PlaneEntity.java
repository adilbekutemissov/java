package server.model;

import server.model.keys.PlaneEntityPK;

import javax.persistence.*;

@Entity
@Table(name = "plane", schema = "public", catalog = "ear2018zs_22")
@IdClass(PlaneEntityPK.class)
public class PlaneEntity {
    private int id;
    private int airlineId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "airline_id", nullable = false)
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

        PlaneEntity that = (PlaneEntity) o;

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
