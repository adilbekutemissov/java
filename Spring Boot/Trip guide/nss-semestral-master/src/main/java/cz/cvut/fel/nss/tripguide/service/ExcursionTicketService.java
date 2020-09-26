package cz.cvut.fel.nss.tripguide.service;

import cz.cvut.fel.nss.tripguide.model.ExcursionTicket;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.model.User;
import cz.cvut.fel.nss.tripguide.repository.ExcursionTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * The class Excursion ticket service.
 */
@Service
public class ExcursionTicketService {

    private ExcursionTicketRepository excursionTicketRepository;

    /**
     * Instantiates a new Excursion ticket service.
     *
     * @param excursionTicketRepository the excursion ticket repository
     */
    @Autowired
    public ExcursionTicketService(ExcursionTicketRepository excursionTicketRepository) {
        this.excursionTicketRepository = excursionTicketRepository;
    }

    /**
     * Save excursion ticket.
     *
     * @param excursionTicket the excursion ticket
     * @return the excursion ticket
     */
    public ExcursionTicket save(ExcursionTicket excursionTicket) {
        return excursionTicketRepository.save(excursionTicket);
    }

    /**
     * Find tickets by tourist.
     *
     * @param tourist the tourist
     * @return the set
     */
    public Set<ExcursionTicket> findTicketsByTourist(User tourist) {
        return excursionTicketRepository.findAllByTourist(tourist);
    }

    /**
     * Find tickets by tourist and tour.
     *
     * @param tourist the tourist
     * @param tour    the tour
     * @return the set
     */
    public Set<ExcursionTicket> findTicketsByTouristAndTour(User tourist, Tour tour) {
        return excursionTicketRepository.findAllByTouristAndExcursionTour(tourist, tour);
    }
}
