package cz.cvut.fel.nss.tripguide.repository;

import cz.cvut.fel.nss.tripguide.model.Event;
import cz.cvut.fel.nss.tripguide.model.Role;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Find user by username.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);

    /**
     * Find user by email.
     *
     * @param email the email
     * @return the user
     */
    User findByEmail(String email);

    /**
     * Find all users by order by id desc.
     *
     * @return the set of users
     */
    Set<User> findAllByOrderByIdDesc();

    /**
     * Find all by tours contains.
     *
     * @param tour the tour
     * @return the set of users
     */
    Set<User> findAllByToursContains(Tour tour);

    /**
     * Find all by events contains.
     *
     * @param event the event
     * @return the set if users
     */
    Set<User> findAllByEventsContains(Event event);

    /**
     * Find all by roles contains.
     *
     * @param role the role
     * @return the set of users
     */
    Set<User> findAllByRolesContains(Role role);
}

