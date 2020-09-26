package server.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PlaneseatEntityPK implements Serializable {
    private int number;
    private int planeid;

    public PlaneseatEntityPK() {
    }

    @Column(name = "number")
    @Id
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Column(name = "planeid")
    @Id
    public int getPlaneid() {
        return planeid;
    }

    public void setPlaneid(int planeid) {
        this.planeid = planeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneseatEntityPK that = (PlaneseatEntityPK) o;
        return number == that.number &&
                planeid == that.planeid;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, planeid);
    }
}
