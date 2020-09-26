package cz.cvut.fel.nss.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * The class Hotel represents Hotel entity.
 */
@Entity
public class Hotel extends AbstractEntity {

    private String address;

    private String email;

    private String name;

    private Integer stars;

    private String phoneNumber;

    private String web;

    private String mealServiceInfo;

    @JsonIgnore
    @ManyToOne
    private Destination destination;

    @JsonIgnore
    @OneToOne(mappedBy = "hotel")
    private Tour tour;

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets meal service info.
     *
     * @return the meal service info
     */
    public String getMealServiceInfo() {
        return mealServiceInfo;
    }

    /**
     * Sets meal service info.
     *
     * @param mealServiceInfo the meal service info
     */
    public void setMealServiceInfo(String mealServiceInfo) {
        this.mealServiceInfo = mealServiceInfo;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets stars.
     *
     * @return the stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * Sets stars.
     *
     * @param stars the stars
     */
    public void setStars(Integer stars) {
        this.stars = stars;
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
     * Gets web.
     *
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * Sets web.
     *
     * @param web the web
     */
    public void setWeb(String web) {
        this.web = web;
    }

    /**
     * Gets destination.
     *
     * @return the destination
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Sets destination.
     *
     * @param destination the destination
     */
    public void setDestination(Destination destination) {
        this.destination = destination;
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
}
