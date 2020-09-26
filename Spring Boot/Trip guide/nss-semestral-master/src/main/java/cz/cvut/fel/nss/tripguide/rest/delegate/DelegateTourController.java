package cz.cvut.fel.nss.tripguide.rest.delegate;

import cz.cvut.fel.nss.tripguide.dto.EventDto;
import cz.cvut.fel.nss.tripguide.dto.MessageDto;
import cz.cvut.fel.nss.tripguide.model.Event;
import cz.cvut.fel.nss.tripguide.model.Message;
import cz.cvut.fel.nss.tripguide.model.User;
import cz.cvut.fel.nss.tripguide.service.EventService;
import cz.cvut.fel.nss.tripguide.service.MessageService;
import cz.cvut.fel.nss.tripguide.service.TourService;
import cz.cvut.fel.nss.tripguide.service.UserService;
import org.hibernate.event.spi.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * The class Delegate tour controller.
 */
@RestController
public class DelegateTourController {

    private final TourService tourService;

    private final UserService userService;

    private final MessageService messageService;

    private final EventService eventService;

    /**
     * Instantiates a new Delegate tour controller.
     *
     * @param tourService    the tour service
     * @param userService    the user service
     * @param messageService the message service
     * @param eventService   the event service
     */
    @Autowired
    public DelegateTourController(TourService tourService, UserService userService, MessageService messageService, EventService eventService) {
        this.tourService = tourService;
        this.userService = userService;
        this.messageService = messageService;
        this.eventService = eventService;
    }

    /**
     * Message dto.
     *
     * @return the new message dto
     */
    @ModelAttribute("newmessage")
    public MessageDto messageDto() {
        return new MessageDto();
    }

    /**
     * Event dto.
     *
     * @return the new event dto
     */
    @ModelAttribute("newevent")
    public EventDto eventDto() {
        return new EventDto();
    }

    /**
     * Get tour.
     *
     * @param model the model
     * @param id    the id
     * @return the model and view
     */
    @GetMapping("/delegate/tour/{id}")
    public ModelAndView getTour(Model model, @PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("tour", tourService.findTour(id));
        model.addAttribute("tourists", userService.getTouristsByTour(tourService.findTour(id)));
        model.addAttribute("messages", messageService.findMessagesByTour(id));
        model.addAttribute("events", eventService.findEventsByTour(tourService.findTour(id)));
        model.addAttribute("types", EventType.values());
        mv.setViewName("delegate/tour");
        return mv;
    }

    /**
     * Add message.
     *
     * @param id         the id
     * @param messageDto the message dto
     * @return the model and view
     */
    @PostMapping("/delegate/tour/{id}/message")
    public ModelAndView addMessage(@PathVariable Integer id, @ModelAttribute("newmessage") @Valid MessageDto messageDto) {
        ModelAndView mv = new ModelAndView();
        Message message = new Message();
        message.setText(messageDto.getText());
        message.setTour(tourService.findTour(id));
        messageService.save(message);
        mv.setViewName("redirect:/delegate/tour/" + id + "?mess");
        return mv;
    }

    /**
     * Get messages by tour.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/delegate/tour/{id}/message")
    public String getMessagesByTour(@PathVariable Integer id) {
        StringBuilder messages = new StringBuilder();
        for (Message message : messageService.findMessagesByTour(id)) {
            messages.append("Text:").append(message.getText()).append("\n");
        }
        return messages.toString();
    }

    /**
     * Add event.
     *
     * @param id       the id
     * @param eventDto the event dto
     * @return the model and view
     */
    @PostMapping("/delegate/tour/{id}/event")
    public ModelAndView addEvent(@PathVariable Integer id, @ModelAttribute("newevent") @Valid EventDto eventDto) {
        ModelAndView mv = new ModelAndView();
        Event event = new Event();
        event.setTitle(eventDto.getTitle());
        event.setStart(LocalDateTime.parse(eventDto.getStart()));
        event.setEnd(LocalDateTime.parse(eventDto.getEnd()));
        event.setLocation(eventDto.getLocation());
        event.setTour(tourService.findTour(id));
        eventService.save(event);
        mv.setViewName("redirect:/delegate/tour/" + id + "?events");
        return mv;
    }

    /**
     * Add tourist to event.
     *
     * @param eventid  the eventid
     * @param tourid   the tourid
     * @param username the username
     * @return the model and view
     */
    @PostMapping("/delegate/tour/{tourid}/event/{eventid}/addtourist")
    public ModelAndView addTouristToEvent(@PathVariable Integer eventid, @PathVariable Integer tourid, @RequestParam String username) {
        ModelAndView mv = new ModelAndView();
        User user = userService.findUser(username);
        Event event = eventService.findEvent(eventid);
        user = userService.addEvent(user, event);
        mv.setViewName("redirect:/delegate/tour/" + tourid + "?events");
        return mv;
    }
}
