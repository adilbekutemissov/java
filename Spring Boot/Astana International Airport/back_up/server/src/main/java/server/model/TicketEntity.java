package server.model;

import server.model.keys.TicketEntityPK;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "ticket", schema = "public", catalog = "ear2018zs_22")
@IdClass(TicketEntityPK.class)
public class TicketEntity {
    private int id;
    private int passengerId;
    private int flightId;
    private BigInteger price;
    private int seatNumber;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "passenger_id", nullable = false)
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    @Id
    @Column(name = "flight_id", nullable = false)
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @Basic
    @Column(name = "seat_number", nullable = false)
    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntity that = (TicketEntity) o;

        if (id != that.id) return false;
        if (passengerId != that.passengerId) return false;
        if (flightId != that.flightId) return false;
        if (seatNumber != that.seatNumber) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + passengerId;
        result = 31 * result + flightId;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + seatNumber;
        return result;
    }
}
