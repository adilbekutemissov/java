package cz.cvut.fel.nss.tripguide.service;

import cz.cvut.fel.nss.tripguide.model.Destination;
import cz.cvut.fel.nss.tripguide.model.LocalAttraction;
import cz.cvut.fel.nss.tripguide.repository.LocalAttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * The class Local attraction service.
 */
@Service
public class LocalAttractionService {

    private final LocalAttractionRepository localAttractionRepository;

    /**
     * Instantiates a new Local attraction service.
     *
     * @param localAttractionRepository the local attraction repository
     */
    @Autowired
    public LocalAttractionService(LocalAttractionRepository localAttractionRepository) {
        this.localAttractionRepository = localAttractionRepository;
    }

    /**
     * Save local attraction.
     *
     * @param localAttraction the local attraction
     * @return the local attraction
     */
    public LocalAttraction save(LocalAttraction localAttraction) {
        return localAttractionRepository.save(localAttraction);
    }

    /**
     * Remove localAttraction.
     *
     * @param localAttraction the local attraction to remove
     */
    public void remove(LocalAttraction localAttraction) {
        localAttractionRepository.delete(localAttraction);
    }

    /**
     * Remove localAttraction by id.
     *
     * @param id the id
     */
    public void remove(Integer id) {
        localAttractionRepository.deleteById(id);
    }


    /**
     * Gets local attractions by destination.
     *
     * @param destination the destination
     * @return the local attractions by destination
     */
    public Set<LocalAttraction> getLocalAttractionsByDestination(Destination destination) {
        return localAttractionRepository.findAllByDestinationOrderByIdDesc(destination);
    }
}
