package cz.cvut.fel.nss.tripguide.repository;

import cz.cvut.fel.nss.tripguide.model.Excursion;
import cz.cvut.fel.nss.tripguide.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * The interface Excursion repository.
 */
public interface ExcursionRepository extends JpaRepository<Excursion, Integer> {

    /**
     * Find by tour.
     *
     * @param tour the tour
     * @return the set of tours
     */
    Set<Excursion> findByTour(Tour tour);

}
