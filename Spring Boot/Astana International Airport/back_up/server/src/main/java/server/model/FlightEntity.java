package server.model;

import server.model.keys.FlightEntityPK;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "flight", schema = "public", catalog = "ear2018zs_22")
@IdClass(FlightEntityPK.class)
public class FlightEntity {
    private int id;
    private int planeId;
    private int airlineId;
    private Timestamp departmentDate;
    private Timestamp arrivalsDate;
    private String arrival;
    private String department;
    private int distance;
    private int seatsCapacity;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "plane_id", nullable = false)
    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    @Id
    @Column(name = "airline_id", nullable = false)
    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    @Basic
    @Column(name = "department_date", nullable = false)
    public Timestamp getDepartmentDate() {
        return departmentDate;
    }

    public void setDepartmentDate(Timestamp departmentDate) {
        this.departmentDate = departmentDate;
    }

    @Basic
    @Column(name = "arrivals_date", nullable = false)
    public Timestamp getArrivalsDate() {
        return arrivalsDate;
    }

    public void setArrivalsDate(Timestamp arrivalsDate) {
        this.arrivalsDate = arrivalsDate;
    }

    @Basic
    @Column(name = "arrival", nullable = false, length = 30)
    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @Basic
    @Column(name = "department", nullable = false, length = 30)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "distance", nullable = false)
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "seats_capacity", nullable = false)
    public int getSeatsCapacity() {
        return seatsCapacity;
    }

    public void setSeatsCapacity(int seatsCapacity) {
        this.seatsCapacity = seatsCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightEntity that = (FlightEntity) o;

        if (id != that.id) return false;
        if (planeId != that.planeId) return false;
        if (airlineId != that.airlineId) return false;
        if (distance != that.distance) return false;
        if (seatsCapacity != that.seatsCapacity) return false;
        if (departmentDate != null ? !departmentDate.equals(that.departmentDate) : that.departmentDate != null)
            return false;
        if (arrivalsDate != null ? !arrivalsDate.equals(that.arrivalsDate) : that.arrivalsDate != null) return false;
        if (arrival != null ? !arrival.equals(that.arrival) : that.arrival != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + planeId;
        result = 31 * result + airlineId;
        result = 31 * result + (departmentDate != null ? departmentDate.hashCode() : 0);
        result = 31 * result + (arrivalsDate != null ? arrivalsDate.hashCode() : 0);
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + distance;
        result = 31 * result + seatsCapacity;
        return result;
    }
}
