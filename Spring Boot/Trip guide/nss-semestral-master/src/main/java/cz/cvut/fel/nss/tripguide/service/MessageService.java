package cz.cvut.fel.nss.tripguide.service;

import cz.cvut.fel.nss.tripguide.exception.NotFoundException;
import cz.cvut.fel.nss.tripguide.model.Message;
import cz.cvut.fel.nss.tripguide.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 * The class Message service.
 */
@Service
public class MessageService {
    private final MessageRepository messageRepository;

    private final TourService tourService;

    /**
     * Instantiates a new Message service.
     *
     * @param messageRepository the message repository
     * @param tourService       the tour service
     */
    @Autowired
    public MessageService(MessageRepository messageRepository, TourService tourService) {
        this.messageRepository = messageRepository;
        this.tourService = tourService;
    }

    /**
     * Find message.
     *
     * @param id the id
     * @return the message
     */
    public Message findMessage(Integer id) {
        Optional<Message> message = messageRepository.findById(id);
        if (!message.isPresent()) {
            throw new NotFoundException("Message not found! ID: " + id);
        }
        return message.get();
    }

    /**
     * Find messages by tour.
     *
     * @param tourId the tour id
     * @return the set
     */
    public Set<Message> findMessagesByTour(Integer tourId) {
        return messageRepository.findAllByTourOrderByIdDesc(tourService.findTour(tourId));
    }

    /**
     * Save message.
     *
     * @param message the message
     * @return the message
     */
    public Message save(Message message) {
        return this.messageRepository.save(message);
    }

    /**
     * Remove message.
     *
     * @param message the message to remove
     */
    public void remove(Message message) {
        this.messageRepository.delete(message);
    }

    /**
     * Remove message by id.
     *
     * @param id the id
     */
    public void remove(Integer id) {
        this.messageRepository.deleteById(id);
    }
}
