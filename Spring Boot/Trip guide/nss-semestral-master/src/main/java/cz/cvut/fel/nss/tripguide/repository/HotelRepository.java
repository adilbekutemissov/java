package cz.cvut.fel.nss.tripguide.repository;

import cz.cvut.fel.nss.tripguide.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

/**
 * The interface Hotel repository.
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    /**
     * Find by name.
     *
     * @param name the name
     * @return the optional
     */
    Optional<Hotel> findByName(String name);

    /**
     * Find all by order by id desc.
     *
     * @return the set hotels
     */
    Set<Hotel> findAllByOrderByIdDesc();

    /**
     * Find all by order by name asc.
     *
     * @return the set of hotels
     */
    Set<Hotel> findAllByOrderByNameAsc();
}
