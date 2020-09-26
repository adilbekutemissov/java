package cz.cvut.fel.nss.tripguide.service;

import cz.cvut.fel.nss.tripguide.exception.NotFoundException;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.model.User;
import cz.cvut.fel.nss.tripguide.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * The class Tour service.
 */
@Service
public class TourService {

    private final TourRepository tourRepository;

    /**
     * Instantiates a new Tour service.
     *
     * @param tourRepository the tour repository
     * @param userService    the user service
     */
    @Autowired
    public TourService(TourRepository tourRepository, UserService userService) {
        this.tourRepository = tourRepository;
    }

    /**
     * Save tour.
     *
     * @param tour the tour
     * @return the tour
     */
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }

    /**
     * Gets all tours.
     *
     * @return the all tours
     */
    public Set<Tour> getAllTours() {
        return tourRepository.findAllByOrderByIdDesc();
    }

    /**
     * Find tour.
     *
     * @param id the id
     * @return the tour
     */
    @Cacheable(value = "tourCache")
    public Tour findTour(Integer id) {
        Optional<Tour> tour = tourRepository.findById(id);

        if (!tour.isPresent()) {
            throw new NotFoundException("Tour not found! ID: " + id);
        }
        return tour.get();
    }

    /**
     * Find tours by delegate.
     *
     * @param delegate the delegate
     * @return the set
     */
    public Set<Tour> findToursByDelegate(User delegate) {
        return tourRepository.findAllByDelegateOrderByIdDesc(delegate);
    }

    /**
     * Find tours by tourist.
     *
     * @param tourist the tourist
     * @return the set
     */
    public Set<Tour> findToursByTourist(User tourist) {
        return tourRepository.findAllByUsersContains(tourist);
    }

    /**
     * Remove tour by id.
     *
     * @param id the id
     */
    public void remove(Integer id) {
        this.tourRepository.deleteById(id);
    }

    /**
     * Remove tour.
     *
     * @param tour the tour to remove
     */
    public void remove(Tour tour) {
        this.tourRepository.delete(tour);
    }

}
