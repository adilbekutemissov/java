package cz.cvut.fel.nss.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * The class Event represents Event entity.
 */
@Entity
public class Event extends AbstractEntity {

    private String title;

    private LocalDateTime start;

    private LocalDateTime end;

    private String location;

    @ManyToOne
    private Tour tour;

    @JsonIgnore
    @ManyToMany
    private Set<User> users = new HashSet<>();

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
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * Sets end.
     *
     * @param end the end
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets tour.
     *
     * @return the tour
     */
    public Tour getTour() {
        return tour;
    }

    /**
     * Sets tour.
     *
     * @param tour the tour
     */
    public void setTour(Tour tour) {
        this.tour = tour;
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
     * Remove user.
     *
     * @param user the user
     */
    public void removeUser(User user) {
        this.users.remove(user);
    }
}
