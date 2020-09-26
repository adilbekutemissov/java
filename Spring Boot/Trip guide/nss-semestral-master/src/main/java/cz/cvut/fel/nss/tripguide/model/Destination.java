package cz.cvut.fel.nss.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * The class Destination represents Destination entity.
 */
@Entity
public class Destination extends AbstractEntity {

    private String name;

    private String country;

    @JsonIgnore
    @OneToMany(mappedBy = "destination")
    private Set<Hotel> hotels = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "destination")
    private Set<LocalAttraction> localAttractions = new HashSet<>();

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
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets hotels.
     *
     * @return the hotels
     */
    public Set<Hotel> getHotels() {
        return hotels;
    }

    /**
     * Sets hotels.
     *
     * @param hotels the hotels
     */
    public void setHotels(Set<Hotel> hotels) {
        this.hotels = hotels;
    }

    /**
     * Add hotel.
     *
     * @param hotel the hotel
     */
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    /**
     * Gets local attractions.
     *
     * @return the local attractions
     */
    public Set<LocalAttraction> getLocalAttractions() {
        return localAttractions;
    }

    /**
     * Sets local attractions.
     *
     * @param localAttractions the local attractions
     */
    public void setLocalAttractions(Set<LocalAttraction> localAttractions) {
        this.localAttractions = localAttractions;
    }

}
