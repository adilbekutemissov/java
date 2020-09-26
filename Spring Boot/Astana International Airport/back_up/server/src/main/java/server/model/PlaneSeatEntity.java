package server.model;

import javax.persistence.*;

@Entity
@Table(name = "plane_seat", schema = "public", catalog = "ear2018zs_22")
public class PlaneSeatEntity {
    private int number;
    private int planeId;
    private Boolean free;

    @Basic
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Id
    @Basic
    @Column(name = "plane_id", nullable = false)
    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaneSeatEntity that = (PlaneSeatEntity) o;

        if (number != that.number) return false;
        if (planeId != that.planeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + planeId;
        return result;
    }

    @Basic
    @Column(name = "free", nullable = true)
    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }
}
