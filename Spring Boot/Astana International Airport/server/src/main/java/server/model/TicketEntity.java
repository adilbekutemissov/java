package server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "ticket", schema = "airbook", catalog = "ear2018zs_22")
public class TicketEntity {
    private int id;
    private int passengerid;
    private int flightid;
    private BigInteger price;
    private Integer seatnumber;

    private PassengerEntity passengerByPassengerid;
    private FlightEntity flightByFlightid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "passengerid")
    public int getPassengerid() {
        return passengerid;
    }

    public void setPassengerid(int passengerid) {
        this.passengerid = passengerid;
    }

    @Basic
    @Column(name = "flightid")
    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    @Basic
    @Column(name = "price")
    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @Basic
    @Column(name = "seatnumber")
    public Integer getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(Integer seatnumber) {
        this.seatnumber = seatnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity that = (TicketEntity) o;
        return id == that.id &&
                passengerid == that.passengerid &&
                flightid == that.flightid &&
                Objects.equals(price, that.price) &&
                Objects.equals(seatnumber, that.seatnumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, passengerid, flightid, price, seatnumber);
    }

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "passengerid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public PassengerEntity getPassengerByPassengerid() {
        return passengerByPassengerid;
    }

    public void setPassengerByPassengerid(PassengerEntity passengerByPassengerid) {
        this.passengerByPassengerid = passengerByPassengerid;
    }

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "flightid", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public FlightEntity getFlightByFlightid() {
        return flightByFlightid;
    }

    public void setFlightByFlightid(FlightEntity flightByFlightid) {
        this.flightByFlightid = flightByFlightid;
    }
}
