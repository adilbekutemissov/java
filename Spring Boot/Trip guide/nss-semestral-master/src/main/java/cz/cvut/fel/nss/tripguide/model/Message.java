package cz.cvut.fel.nss.tripguide.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.temporal.ChronoUnit;

/**
 * The class Message represents Message entity.
 */
@Entity
public class Message extends AbstractEntity {

    private String text;

    @ManyToOne
    private Tour tour;

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
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
     * Gets creation date.
     *
     * @return the creation date
     */
    public String getCreateDate() {
        if (getCreatedat() != null) {
            return getCreatedat().truncatedTo(ChronoUnit.MINUTES).toString().replace('T', ' ');
        } else {
            return "";
        }
    }
}
