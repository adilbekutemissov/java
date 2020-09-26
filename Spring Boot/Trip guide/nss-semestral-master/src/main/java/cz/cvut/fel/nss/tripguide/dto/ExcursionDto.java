package cz.cvut.fel.nss.tripguide.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * The type Excursion dto.
 */
public class ExcursionDto {

    @NotEmpty
    @NotNull
    private String title;

    @NotEmpty
    @NotNull
    private String description;

    @NotEmpty
    @NotNull
    private String price;

    @NotNull
    @NotEmpty
    private String start;

    @NotNull
    @NotEmpty
    private String end;

    @NotNull
    @NotEmpty
    private String meetingLocation;

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
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public String getStart() {
        return start;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * Sets end.
     *
     * @param end the end
     */
    public void setEnd(String end) {
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
}
