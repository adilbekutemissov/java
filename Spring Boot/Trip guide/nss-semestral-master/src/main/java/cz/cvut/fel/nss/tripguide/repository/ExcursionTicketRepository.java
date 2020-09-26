package cz.cvut.fel.nss.tripguide.repository;

import cz.cvut.fel.nss.tripguide.model.ExcursionTicket;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * The interface Excursion ticket repository.
 */
public interface ExcursionTicketRepository extends JpaRepository<ExcursionTicket, Integer> {

    /**
     * Find all by tourist.
     *
     * @param user the user
     * @return the set of tickets
     */
    Set<ExcursionTicket> findAllByTourist(User user);

    /**
     * Find all by tourist and excursion tour.
     *
     * @param user the user
     * @param tour the tour
     * @return the set of tickets
     */
    Set<ExcursionTicket> findAllByTouristAndExcursionTour(User user, Tour tour);
}
