package cz.cvut.fel.nss.tripguide.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Hotel dto.
 */
public class HotelDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phoneNumbrer;

    @NotEmpty
    private String stars;

    @NotEmpty
    private String web;

    @NotNull
    private Integer destination;

    @NotEmpty
    private String mealServiceInfo;

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
     * Gets phone numbrer.
     *
     * @return the phone numbrer
     */
    public String getPhoneNumbrer() {
        return phoneNumbrer;
    }

    /**
     * Sets phone numbrer.
     *
     * @param phoneNumbrer the phone numbrer
     */
    public void setPhoneNumbrer(String phoneNumbrer) {
        this.phoneNumbrer = phoneNumbrer;
    }

    /**
     * Gets stars.
     *
     * @return the stars
     */
    public String getStars() {
        return stars;
    }

    /**
     * Sets stars.
     *
     * @param stars the stars
     */
    public void setStars(String stars) {
        this.stars = stars;
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
    public Integer getDestination() {
        return destination;
    }

    /**
     * Sets destination.
     *
     * @param destination the destination
     */
    public void setDestination(Integer destination) {
        this.destination = destination;
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
}
