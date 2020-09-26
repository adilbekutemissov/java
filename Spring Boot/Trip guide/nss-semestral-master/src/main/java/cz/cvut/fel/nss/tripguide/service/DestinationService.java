package cz.cvut.fel.nss.tripguide.service;

import cz.cvut.fel.nss.tripguide.exception.NotFoundException;
import cz.cvut.fel.nss.tripguide.model.Destination;
import cz.cvut.fel.nss.tripguide.model.Hotel;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The class Destination service.
 */
@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    /**
     * Instantiates a new Destination service.
     *
     * @param destinationRepository the destination repository
     */
    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    /**
     * Save destination.
     *
     * @param destination the destination
     * @return the destination
     */
    public Destination save(Destination destination) {
        return destinationRepository.save(destination);
    }

    /**
     * Remove destination by id.
     *
     * @param id the id of destination to remove
     */
    public void remove(Integer id) {
        destinationRepository.deleteById(id);
    }

    /**
     * Remove destination.
     *
     * @param destination the destination ot remove
     */
    public void remove(Destination destination) {
        destinationRepository.delete(destination);
    }

    /**
     * Find destination.
     *
     * @param id the id of destination
     * @return the destination
     */
    public Destination findDestination(Integer id) {
        Optional<Destination> description = destinationRepository.findById(id);
        if (!description.isPresent()) {
            throw new NotFoundException("Destination not found! ID: " + id);
        }
        return description.get();
    }

    /**
     * Gets all destinations.
     *
     * @return the all destinations
     */
    public Set<Destination> getAllDestinations() {
        return destinationRepository.findAllByOrderByIdDesc();
    }

    /**
     * Gets all destinations by name.
     *
     * @return the all destinations by name
     */
    public Set<Destination> getAllDestinationsByName() {
        return destinationRepository.findAllByOrderByNameAsc();
    }

    /**
     * Find all tours by destination id.
     *
     * @param destId the dest id
     * @return the set of tours
     */
    public Set<Tour> findAllDestinationTours(Integer destId) {
        return findDestination(destId).getHotels().stream().map(Hotel::getTour).collect(Collectors.toSet());
    }
}
