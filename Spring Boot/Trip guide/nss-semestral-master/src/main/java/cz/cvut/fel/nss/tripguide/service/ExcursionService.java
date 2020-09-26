package cz.cvut.fel.nss.tripguide.service;

import cz.cvut.fel.nss.tripguide.exception.NotFoundException;
import cz.cvut.fel.nss.tripguide.model.Excursion;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.repository.ExcursionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * The class Excursion service.
 */
@SuppressWarnings("ALL")
@Service
public class ExcursionService {

    private final ExcursionRepository excursionRepository;
    private final DestinationService destinationService;

    /**
     * Instantiates a new Excursion service.
     *
     * @param excursionRepository the excursion repository
     * @param destinationService  the destination service
     */
    @Autowired
    public ExcursionService(ExcursionRepository excursionRepository, DestinationService destinationService) {
        this.excursionRepository = excursionRepository;
        this.destinationService = destinationService;
    }

    /**
     * Save excursion.
     *
     * @param excursion the excursion
     * @return the excursion
     */
    public Excursion save(Excursion excursion) {
        return excursionRepository.save(excursion);
    }

    /**
     * Find excursion.
     *
     * @param id the id
     * @return the excursion
     */
    public Excursion findExcursion(Integer id) {
        Optional<Excursion> excursion = excursionRepository.findById(id);
        if (!excursion.isPresent()) {
            throw new NotFoundException("Excursion not found! ID: " + id);
        }
        return excursion.get();
    }

    /**
     * Find excursions by tour.
     *
     * @param tour the tour
     * @return the set
     */
    public Set<Excursion> findExcursionsByTour(Tour tour) {
        Set<Excursion> excursions = excursionRepository.findByTour(tour);
        return excursions;
    }

    /**
     * Remove excursion by id.
     *
     * @param id the id
     */
    public void remove(Integer id) {
        excursionRepository.deleteById(id);
    }

    /**
     * Remove excursion.
     *
     * @param excursion the excursion to remove
     */
    public void remove(Excursion excursion) {
        excursionRepository.delete(excursion);
    }

    /**
     * Add excursion.
     *
     * @param excursion the excursion
     * @return the excursion
     */
    public Excursion addExcursion(Excursion excursion) {
        excursion = save(excursion);
        return excursion;
    }

}
