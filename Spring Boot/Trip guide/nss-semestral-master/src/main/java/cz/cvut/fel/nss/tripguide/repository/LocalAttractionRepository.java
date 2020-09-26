package cz.cvut.fel.nss.tripguide.repository;

import cz.cvut.fel.nss.tripguide.model.Destination;
import cz.cvut.fel.nss.tripguide.model.LocalAttraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * The interface Local attraction repository.
 */
public interface LocalAttractionRepository extends JpaRepository<LocalAttraction, Integer> {

    /**
     * Find all by destination order by id desc.
     *
     * @param destination the destination
     * @return the set of local attractions
     */
    Set<LocalAttraction> findAllByDestinationOrderByIdDesc(Destination destination);
}
