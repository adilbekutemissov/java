package cz.cvut.fel.nss.tripguide.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * The class Excursion represents Excursion entity.
 */
@Entity
public class Excursion extends AbstractEntity {

    private String title;

    private String description;

    private LocalDateTime start;

    private LocalDateTime end;

    private String meetingLocation;

    private Integer price;

    @JsonIgnore
    @ManyToOne
    private Tour tour;


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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Gets meeting location.
     *
     * @return the meeting location
     */
    public String getMeetingLocation() {
        return meetingLocation;
    }

    /**
     * Sets meeting location.
     *
     * @param meetingLocation the meeting location
     */
    public void setMeetingLocation(String meetingLocation) {
        this.meetingLocation = meetingLocation;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(Integer price) {
        this.price = price;
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
