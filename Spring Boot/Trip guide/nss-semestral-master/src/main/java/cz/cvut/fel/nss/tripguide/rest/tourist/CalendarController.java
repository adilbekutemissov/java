package cz.cvut.fel.nss.tripguide.rest.tourist;

import cz.cvut.fel.nss.tripguide.model.*;
import cz.cvut.fel.nss.tripguide.service.EventService;
import cz.cvut.fel.nss.tripguide.service.ExcursionTicketService;
import cz.cvut.fel.nss.tripguide.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * The class Calendar controller.
 */
@RestController
public class CalendarController {
    private final TourService tourService;
    private final ExcursionTicketService excursionTicketService;
    private final EventService eventService;


    /**
     * Instantiates a new Calendar controller.
     *
     * @param tourService            the tour service
     * @param excursionTicketService the excursion ticket service
     * @param eventService           the event service
     */
    @Autowired
    public CalendarController(TourService tourService, ExcursionTicketService excursionTicketService, EventService eventService) {
        this.tourService = tourService;
        this.excursionTicketService = excursionTicketService;
        this.eventService = eventService;
    }

    /**
     * Get user.
     *
     * @param authentication the authentication
     * @return the set
     */
    @GetMapping("/tourist/calendar/tours")
    public Set<Tour> getUserTours(Authentication authentication) {
        User tourist = (User) authentication.getPrincipal();
        return tourService.findToursByTourist(tourist);
    }

    /**
     * Get user excursions.
     *
     * @param authentication the authentication
     * @return the set if user excursions
     */
    @GetMapping("/tourist/calendar/excursions")
    public Set<Excursion> getUserExcursions(Authentication authentication) {
        User tourist = (User) authentication.getPrincipal();
        Set<Excursion> excursions = new HashSet<>();
        for (ExcursionTicket et : excursionTicketService.findTicketsByTourist(tourist)) {
            excursions.add(et.getExcursion());
        }
        return excursions;
    }

    /**
     * Get user events.
     *
     * @param authentication the authentication
     * @return the set of events
     */
    @GetMapping("/tourist/calendar/events")
    public Set<Event> getUserEvents(Authentication authentication) {
        User tourist = (User) authentication.getPrincipal();
        return eventService.findEventsByTourist(tourist);
    }
}
