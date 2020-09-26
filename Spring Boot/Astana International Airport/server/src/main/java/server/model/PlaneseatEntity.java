package server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "planeseat", schema = "airbook", catalog = "ear2018zs_22")
@IdClass(PlaneseatEntityPK.class)
@NamedQueries({
        @NamedQuery(name = "PlaneEntity.findAllNumberByPlaneid", query  =
                "SELECT PS.number FROM PlaneseatEntity PS WHERE PS.planeid = :planeid ORDER BY PS.number DESC")
})
public class PlaneseatEntity {
    private int number;
    private int planeid;
    private boolean free;
    private PlaneEntity planeByPlaneid;


    @Id
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Id
    @Column(name = "planeid")
    public int getPlaneid() {
        return planeid;
    }



    public void setPlaneid(int planeid) {
        this.planeid = planeid;
    }

    @Basic
    @Column(name = "free")
    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneseatEntity that = (PlaneseatEntity) o;
        return number == that.number &&
                planeid == that.planeid &&
                free == that.free;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, planeid, free);
    }

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "planeid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public PlaneEntity getPlaneByPlaneid() {
        return planeByPlaneid;
    }

    public void setPlaneByPlaneid(PlaneEntity planeByPlaneid) {
        this.planeByPlaneid = planeByPlaneid;
    }
}
