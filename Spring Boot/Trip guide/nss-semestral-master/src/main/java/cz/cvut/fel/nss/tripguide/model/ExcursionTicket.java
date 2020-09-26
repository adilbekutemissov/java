package cz.cvut.fel.nss.tripguide.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * The class Excursion ticket represents Excursion entity.
 */
//@Document(indexName = "elasticsearch", type = "ticket")
@Entity
public class ExcursionTicket extends AbstractEntity {

    @ManyToOne
    private Excursion excursion;
    @ManyToOne
    private User tourist;

    private Integer quantity;

    /**
     * Gets excursion.
     *
     * @return the excursion
     */
    public Excursion getExcursion() {
        return excursion;
    }

    /**
     * Sets excursion.
     *
     * @param excursion the excursion
     */
    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    /**
     * Gets tourist.
     *
     * @return the tourist
     */
    public User getTourist() {
        return tourist;
    }

    /**
     * Sets tourist.
     *
     * @param tourist the tourist
     */
    public void setTourist(User tourist) {
        this.tourist = tourist;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
