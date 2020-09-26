package cz.cvut.fel.nss.tripguide.service;

import cz.cvut.fel.nss.tripguide.exception.NotFoundException;
import cz.cvut.fel.nss.tripguide.model.Event;
import cz.cvut.fel.nss.tripguide.model.Role;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.model.User;
import cz.cvut.fel.nss.tripguide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * The class User service.
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EventService eventService;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository  the user repository
     * @param passwordEncoder the password encoder
     * @param eventService    the event service
     */
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, EventService eventService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.eventService = eventService;
    }

    /**
     * Load user by username.
     *
     * @param s the s
     * @return the user details
     * @throws UsernameNotFoundException the username not found exception
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userFindByUserName = userRepository.findByUsername(s);
        if (userFindByUserName != null) {
            return userFindByUserName;
        }
        return userRepository.findByEmail(s);
    }


    /**
     * Find user by id.
     *
     * @param id the id
     * @return the user
     */
    public User findUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException("User not found! ID: " + id);
        }
        return user.get();
    }

    /**
     * Find user by username.
     *
     * @param username the username
     * @return the user
     */
    public User findUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new NotFoundException("User not found! Username: " + username);
        }
        return user;
    }


    /**
     * Save user.
     *
     * @param user the user to store
     * @return the user
     */
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * Remove user.
     *
     * @param user the user to remove
     */
    public void remove(User user) {
        userRepository.delete(user);
    }

    /**
     * Remove user by id.
     *
     * @param id the id
     */
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public Set<User> getAllUsers() {
        return userRepository.findAllByOrderByIdDesc();
    }

    /**
     * Get tourists by tour.
     *
     * @param tour the tour
     * @return the set
     */
    public Set<User> getTouristsByTour(Tour tour) {
        return userRepository.findAllByToursContains(tour);
    }

    /**
     * Get tourists by role.
     *
     * @param role the role
     * @return the set
     */
    public Set<User> getTouristsByRole(Role role) {
        return userRepository.findAllByRolesContains(role);
    }

    /**
     * set tour in user.
     *
     * @param user the user
     * @param tour the tour
     * @return the user
     */
    public User addTour(User user, Tour tour) {
        user.addTour(tour);
        return save(user);
    }

    /**
     * set event in user.
     *
     * @param user  the user
     * @param event the event
     * @return the user
     */
    public User addEvent(User user, Event event) {
        event.addUser(user);
        event = eventService.save(event);
        return save(user);
    }

}