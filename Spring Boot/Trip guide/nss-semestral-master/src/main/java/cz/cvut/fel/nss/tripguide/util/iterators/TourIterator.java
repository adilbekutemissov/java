package cz.cvut.fel.nss.tripguide.util.iterators;

import cz.cvut.fel.nss.tripguide.model.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * The class Tour iterator.
 */
public class TourIterator implements Iterator {

    private List<Tour> tours = new ArrayList<>();

    private int pos = 0;

    /**
     * Instantiates a new Tour iterator.
     *
     * @param tours the tours
     */
    public TourIterator(Set<Tour> tours) {
        this.tours.addAll(tours);
    }

    /**
     * Has next.
     *
     * @return the boolean
     */
    @Override
    public boolean hasNext() {
        return pos < tours.size() && tours.get(pos) != null;
    }

    /**
     * Gets next item.
     *
     * @return the next
     */
    @Override
    public Tour getNext() {
        Tour tour = tours.get(pos);
        pos++;
        return tour;
    }
}
