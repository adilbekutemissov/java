package server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "flight", schema = "airbook", catalog = "ear2018zs_22")
public class FlightEntity {
    private int id;
    private int planeid;
    private int airlineid;
    private Timestamp departmentdate;
    private Timestamp arrilvalsdate;
    private String department;
    private String arrival;
    private int distance;
    private int terminalid;
    private AirlineEntity airlineByAirlineid;
    private TerminalEntity terminalByTerminalid;
    private List<TicketEntity> ticketsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "planeid")
    public int getPlaneid() {
        return planeid;
    }

    public void setPlaneid(int planeid) {
        this.planeid = planeid;
    }

    @Basic
    @Column(name = "airlineid")
    public int getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(int airlineid) {
        this.airlineid = airlineid;
    }

    @Basic
    @CreationTimestamp
    @Column(name = "departmentdate")
    public Timestamp getDepartmentdate() {
        return departmentdate;
    }

    public void setDepartmentdate(Timestamp departmentdate) {
        this.departmentdate = departmentdate;
    }

    @Basic
    @CreationTimestamp
    @Column(name = "arrilvalsdate")
    public Timestamp getArrilvalsdate() {
        return arrilvalsdate;
    }

    public void setArrilvalsdate(Timestamp arrilvalsdate) {
        this.arrilvalsdate = arrilvalsdate;
    }

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "arrival")
    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @Basic
    @Column(name = "distance")
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Basic
    @Column(name = "terminalid")
    public int getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(int terminalid) {
        this.terminalid = terminalid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightEntity that = (FlightEntity) o;
        return id == that.id &&
                planeid == that.planeid &&
                airlineid == that.airlineid &&
                distance == that.distance &&
                terminalid == that.terminalid &&
                Objects.equals(departmentdate, that.departmentdate) &&
                Objects.equals(arrilvalsdate, that.arrilvalsdate) &&
                Objects.equals(department, that.department) &&
                Objects.equals(arrival, that.arrival);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, planeid, airlineid, departmentdate, arrilvalsdate, department, arrival, distance, terminalid);
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

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "terminalid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public TerminalEntity getTerminalByTerminalid() {
        return terminalByTerminalid;
    }

    public void setTerminalByTerminalid(TerminalEntity terminalByTerminalid) {
        this.terminalByTerminalid = terminalByTerminalid;
    }


    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "flightByFlightid")
    public List<TicketEntity> getTicketsById() {
        return ticketsById;
    }

    public void setTicketsById(List<TicketEntity> ticketsById) {
        this.ticketsById = ticketsById;
    }
}
