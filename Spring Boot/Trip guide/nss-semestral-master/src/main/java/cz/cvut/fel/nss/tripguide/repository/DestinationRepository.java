package cz.cvut.fel.nss.tripguide.repository;

import cz.cvut.fel.nss.tripguide.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

/**
 * The interface Destination repository.
 */
public interface DestinationRepository extends JpaRepository<Destination, Integer> {

    /**
     * Find by name.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Destination> findByName(String name);

    /**
     * Find all by order by id desc.
     *
     * @return the set
     */
    Set<Destination> findAllByOrderByIdDesc();

    /**
     * Find all by order by name asc.
     *
     * @return the set
     */
    Set<Destination> findAllByOrderByNameAsc();

}
