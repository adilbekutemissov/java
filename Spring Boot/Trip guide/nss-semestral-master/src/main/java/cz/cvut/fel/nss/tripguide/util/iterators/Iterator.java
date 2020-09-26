package cz.cvut.fel.nss.tripguide.util.iterators;

import cz.cvut.fel.nss.tripguide.model.AbstractEntity;

/**
 * The interface Iterator.
 */
public interface Iterator {

    /**
     * Has next.
     *
     * @return the boolean
     */
    boolean hasNext();

    /**
     * Gets next item.
     *
     * @return the next
     */
    AbstractEntity getNext();
}
