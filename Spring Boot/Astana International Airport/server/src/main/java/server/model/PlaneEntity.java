package server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "plane", schema = "airbook", catalog = "ear2018zs_22")
public class PlaneEntity {
    private int id;
    private int airlineid;
    private AirlineEntity airlineByAirlineid;
    private List<PlaneseatEntity> planeseatsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneEntity that = (PlaneEntity) o;
        return id == that.id &&
                airlineid == that.airlineid;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, airlineid);
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

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "planeByPlaneid")
    public List<PlaneseatEntity> getPlaneseatsById() {
        return planeseatsById;
    }

    public void setPlaneseatsById(List<PlaneseatEntity> planeseatsById) {
        this.planeseatsById = planeseatsById;
    }
}
