package cz.cvut.fel.nss.tripguide.repository;

import cz.cvut.fel.nss.tripguide.model.Event;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * The interface Event repository.
 */
public interface EventRepository extends JpaRepository<Event, Integer> {

    /**
     * Find all by tour order by id desc.
     *
     * @param tour the tour
     * @return the set
     */
    Set<Event> findAllByTourOrderByIdDesc(Tour tour);

    /**
     * Find all by users contains.
     *
     * @param user the user
     * @return the set
     */
    Set<Event> findAllByUsersContains(User user);

    /**
     * Find all by tour and users contains.
     *
     * @param tour the tour
     * @param user the user
     * @return the set
     */
    Set<Event> findAllByTourAndUsersContains(Tour tour, User user);

    /**
     * Find all by tour and users not contains.
     *
     * @param tour the tour
     * @param user the user
     * @return the set
     */
    Set<Event> findAllByTourAndUsersNotContains(Tour tour, User user);
}
