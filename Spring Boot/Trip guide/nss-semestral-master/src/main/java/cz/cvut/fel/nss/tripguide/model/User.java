package cz.cvut.fel.nss.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The class User represents User entity.
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAllUsers", query = "SELECT e FROM User e")
public class User extends AbstractEntity implements UserDetails {

    @NotNull
    private String username;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;

    private String phoneNumber;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonIgnore
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "userid"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<Event> events = new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private Set<Tour> tours = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "delegate")
    private Set<Tour> tourToDelegate;

    @NotNull
    private String fullName;

    private boolean active;

    /**
     * Gets authorities.
     *
     * @return the authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Is account non expired boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * Is account non locked boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Is credentials non expired boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Is enabled boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean isEnabled() {
        return isActive();
    }

    /**
     * Is active boolean.
     *
     * @return the boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets active.
     *
     * @param active the active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
     * Add event.
     *
     * @param e the e
     */
    public void addEvent(Event e) {
        this.events.add(e);
    }

    /**
     * Remove event.
     *
     * @param e the e
     */
    public void removeEvent(Event e) {
        this.events.remove(e);
    }

    /**
     * Gets tours.
     *
     * @return the tours
     */
    public Set<Tour> getTours() {
        return tours;
    }

    /**
     * Sets tours.
     *
     * @param tours the tours
     */
    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    /**
     * Add tour.
     *
     * @param t the t
     */
    public void addTour(Tour t) {
        this.tours.add(t);
    }

    /**
     * Gets tour to delegate.
     *
     * @return the tour to delegate
     */
    public Set<Tour> getTourToDelegate() {
        return tourToDelegate;
    }

    /**
     * Sets tour to delegate.
     *
     * @param tourToDelegate the tour to delegate
     */
    public void setTourToDelegate(Set<Tour> tourToDelegate) {
        this.tourToDelegate = tourToDelegate;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name.
     *
     * @param fullName the full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return active == user.active &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(events, user.events) &&
                Objects.equals(tourToDelegate, user.tourToDelegate);
    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, email, password, phoneNumber, roles, active);
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", roles=" + roles +
                ", active=" + active +
                '}';
    }

    /**
     * Is admin boolean. Returns true if this is admin
     *
     * @return the boolean
     */
    public boolean isAdmin() {
        return getAuthorities().contains(Role.ADMIN);
    }

    /**
     * Is delegate boolean. Returns true if this is delegate
     *
     * @return the boolean
     */
    public boolean isDelegate() {
        return getAuthorities().contains(Role.DELEGATE);
    }

    /**
     * Is tourist boolean. Returns true if this is simple tourist
     *
     * @return the boolean
     */
    public boolean isTourist() {
        return getAuthorities().contains(Role.TOURIST);
    }
}

