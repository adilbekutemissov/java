package cz.cvut.fel.nss.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * The class Tour represents Tour entity.
 */
@Entity
public class Tour extends AbstractEntity {

    private String title;

    private LocalDate start;

    private LocalDate end;

    private String backTransferInfo;

    @JsonIgnore
    @ManyToOne
    private Hotel hotel;

    @JsonIgnore
    @ManyToOne
    private User delegate;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    private Set<Excursion> excursions = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    private Set<Message> messages = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "tour")
    private Set<Event> events = new HashSet<>();


    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public LocalDate getStart() {
        return start;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(LocalDate start) {
        this.start = start;
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * Sets end.
     *
     * @param end the end
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    /**
     * Gets delegate.
     *
     * @return the delegate
     */
    public User getDelegate() {
        return delegate;
    }

    /**
     * Sets delegate.
     *
     * @param delegate the delegate
     */
    public void setDelegate(User delegate) {
        this.delegate = delegate;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * Add user.
     *
     * @param user the user
     */
    public void addUser(User user) {
        this.users.add(user);
    }

    /**
     * Gets hotel.
     *
     * @return the hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets hotel.
     *
     * @param hotel the hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Gets excursions.
     *
     * @return the excursions
     */
    public Set<Excursion> getExcursions() {
        return excursions;
    }

    /**
     * Sets excursions.
     *
     * @param excursions the excursions
     */
    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }

    /**
     * Add excursion.
     *
     * @param excursion the excursion
     */
    public void addExcursion(Excursion excursion) {
        this.excursions.add(excursion);
    }

    /**
     * Gets messages.
     *
     * @return the messages
     */
    public Set<Message> getMessages() {
        return messages;
    }

    /**
     * Sets messages.
     *
     * @param messages the messages
     */
    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    /**
     * Gets events.
     *
     * @return the events
     */
    public Set<Event> getEvents() {
        return events;
    }

    /**
     * Sets events.
     *
     * @param events the events
     */
    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    /**
     * Gets back transfer info.
     *
     * @return the back transfer info
     */
    public String getBackTransferInfo() {
        return backTransferInfo;
    }

    /**
     * Sets back transfer info.
     *
     * @param backTransferInfo the back transfer info
     */
    public void setBackTransferInfo(String backTransferInfo) {
        this.backTransferInfo = backTransferInfo;
    }
}
