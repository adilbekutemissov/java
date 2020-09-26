package server.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "passenger", schema = "airbook", catalog = "ear2018zs_22")
public class PassengerEntity {
    private int id;
    private String email;
    private String name;
    private String surname;
    private String password;
    private int phonenumber;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phonenumber")
    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerEntity that = (PassengerEntity) o;
        return id == that.id &&
                phonenumber == that.phonenumber &&
                Objects.equals(email, that.email) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, name, surname, password, phonenumber);
    }

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true, mappedBy = "passengerByPassengerid")
    public List<TicketEntity> getTicketsById() {
        return ticketsById;
    }

    public void setTicketsById(List<TicketEntity> ticketsById) {
        this.ticketsById = ticketsById;
    }
}
