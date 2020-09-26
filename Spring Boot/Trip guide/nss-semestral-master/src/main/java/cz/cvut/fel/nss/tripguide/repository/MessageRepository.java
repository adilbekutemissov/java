package cz.cvut.fel.nss.tripguide.repository;

import cz.cvut.fel.nss.tripguide.model.Message;
import cz.cvut.fel.nss.tripguide.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * The interface Message repository.
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * Find all by tour order by id desc.
     *
     * @param tour the tour
     * @return the set of messages
     */
    Set<Message> findAllByTourOrderByIdDesc(Tour tour);
}
