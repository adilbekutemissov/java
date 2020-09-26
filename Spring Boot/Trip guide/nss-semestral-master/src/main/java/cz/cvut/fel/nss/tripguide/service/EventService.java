package cz.cvut.fel.nss.tripguide.service;

import cz.cvut.fel.nss.tripguide.exception.NotFoundException;
import cz.cvut.fel.nss.tripguide.model.Event;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.model.User;
import cz.cvut.fel.nss.tripguide.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * The class Event service.
 */
@Service
public class EventService {

    private final EventRepository eventRepository;


    /**
     * Instantiates a new Event service.
     *
     * @param eventRepository the event repository
     */
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    /**
     * Find event.
     *
     * @param id the id
     * @return the event
     */
    public Event findEvent(Integer id) {
        Optional<Event> event = eventRepository.findById(id);
        if (!event.isPresent()) {
            throw new NotFoundException("Message not found! ID: " + id);
        }
        return event.get();
    }

    /**
     * Find events by tour.
     *
     * @param tour the tour
     * @return the set
     */
    public Set<Event> findEventsByTour(Tour tour) {
        return eventRepository.findAllByTourOrderByIdDesc(tour);
    }

    /**
     * Find events by tourist .
     *
     * @param user the user
     * @return the set
     */
    public Set<Event> findEventsByTourist(User user) {
        return eventRepository.findAllByUsersContains(user);
    }

    /**
     * Find events by tour and tourist .
     *
     * @param tour the tour
     * @param user the user
     * @return the set
     */
    public Set<Event> findEventsByTourAndTourist(Tour tour, User user) {
        return eventRepository.findAllByTourAndUsersContains(tour, user);
    }

    /**
     * Find events by tour and not tourist .
     *
     * @param tour the tour
     * @param user the user
     * @return the set
     */
    public Set<Event> findEventsByTourAndNotTourist(Tour tour, User user) {
        return eventRepository.findAllByTourAndUsersNotContains(tour, user);
    }

    /**
     * Save event.
     *
     * @param event the event to save
     * @return the event
     */
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    /**
     * Remove event.
     *
     * @param event the event to remove
     */
    public void remove(Event event) {
        this.eventRepository.delete(event);
    }

    /**
     * Remove event by id.
     *
     * @param id the id of event to remove
     */
    public void remove(Integer id) {
        this.eventRepository.deleteById(id);
    }

    /**
     * Add event.
     *
     * @param event the event
     * @param user  the user
     * @return the event
     */
    public Event addEvent(Event event, User user) {
        event.addUser(user);
        event = save(event);
        return event;
    }

}