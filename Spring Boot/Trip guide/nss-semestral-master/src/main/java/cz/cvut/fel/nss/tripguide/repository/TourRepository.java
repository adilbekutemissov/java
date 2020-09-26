package cz.cvut.fel.nss.tripguide.repository;

import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * The interface Tour repository.
 */
public interface TourRepository extends JpaRepository<Tour, Integer> {

    /**
     * Find all by order by id desc.
     *
     * @return the set of tours
     */
    Set<Tour> findAllByOrderByIdDesc();

    /**
     * Find all by delegate order by id desc.
     *
     * @param user the user
     * @return the set of tours
     */
    Set<Tour> findAllByDelegateOrderByIdDesc(User user);

    /**
     * Find all by users contains.
     *
     * @param user the user
     * @return the set of tours
     */
    Set<Tour> findAllByUsersContains(User user);
}
