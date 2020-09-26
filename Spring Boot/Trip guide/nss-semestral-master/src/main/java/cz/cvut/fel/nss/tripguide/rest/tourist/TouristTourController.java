package cz.cvut.fel.nss.tripguide.rest.tourist;

import cz.cvut.fel.nss.tripguide.model.*;
import cz.cvut.fel.nss.tripguide.service.*;
import cz.cvut.fel.nss.tripguide.util.strategy.CreditCardStrategy;
import cz.cvut.fel.nss.tripguide.util.strategy.PayPalStrategy;
import cz.cvut.fel.nss.tripguide.util.strategy.PaymentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * The class Tourist tour controller.
 */
@RestController
public class TouristTourController {

    private final TourService ts;
    private final LocalAttractionService las;
    private final ExcursionService es;
    private final ExcursionTicketService ets;
    private final EventService evs;
    private final MessageService ms;
    private final UserService us;
    private final KafkaService ks;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "ExcursionTicketReport";

    /**
     * Instantiates a new Tourist tour controller.
     *
     * @param ts  the TourService
     * @param las the LocalAttractionService
     * @param es  the ExcursionService
     * @param ets the ExcursionTicketService
     * @param evs the EventService
     * @param ms  the MessageService
     * @param us  the UserService
     * @param ks  the KafkaService
     */
    @Autowired
    public TouristTourController(TourService ts, LocalAttractionService las, ExcursionService es, ExcursionTicketService ets, EventService evs, MessageService ms, UserService us, KafkaService ks) {
        this.ts = ts;
        this.las = las;
        this.es = es;
        this.ets = ets;
        this.evs = evs;
        this.ms = ms;
        this.us = us;
        this.ks = ks;
    }

    /**
     * Get tour.
     *
     * @param model          the model
     * @param id             the id
     * @param authentication the authentication
     * @return the model and view
     */
    @GetMapping("/tourist/tour/{id}")
    public ModelAndView getTour(Model model, @PathVariable Integer id, Authentication authentication) {
        ModelAndView mv = new ModelAndView();
        User tourist = (User) authentication.getPrincipal();
        Tour tour = ts.findTour(id);
        Set<LocalAttraction> attractions = las.getLocalAttractionsByDestination(tour.getHotel().getDestination());
        Set<Excursion> excursions = es.findExcursionsByTour(tour);
        Set<ExcursionTicket> myExcursions = ets.findTicketsByTouristAndTour(tourist, tour);
        Set<Event> myEvents = evs.findEventsByTourAndTourist(tour, tourist);
        Set<Event> events = evs.findEventsByTourAndNotTourist(tour, tourist);
        Set<Message> messages = ms.findMessagesByTour(id);
        model.addAttribute("tourist", ((User) authentication.getPrincipal()));
        model.addAttribute("tour", tour);
        model.addAttribute("attractions", attractions);
        model.addAttribute("excursions", excursions);
        model.addAttribute("myexcursions", myExcursions);
        model.addAttribute("myevents", myEvents);
        model.addAttribute("events", events);
        model.addAttribute("messages", messages);
        mv.setViewName("tourist/tour");
        return mv;
    }

    /**
     * Buy excursion .
     *
     * @param id             the id
     * @param tourid         the tourid
     * @param quantity       the quantity
     * @param authentication the authentication
     * @return the model and view
     */
    @PostMapping("/tourist/tour/{tourid}/excursion/{id}")
    public ModelAndView buyExcursion(@PathVariable Integer id, @PathVariable Integer tourid, @RequestParam Integer quantity, @RequestParam String payMethod, Authentication authentication) {
        PaymentStrategy strategy;
        String strategyStr = "";
        ModelAndView mv = new ModelAndView();
        Excursion excursion = es.findExcursion(id);
        User tourist = (User) authentication.getPrincipal();
        ExcursionTicket excursionTicket = new ExcursionTicket();
        excursionTicket.setExcursion(excursion);
        excursionTicket.setTourist(tourist);
        excursionTicket.setQuantity(quantity);
        ets.save(excursionTicket);
        if (payMethod.equals("paypal")){
            strategy = new PayPalStrategy();
            strategyStr = strategy.pay(excursionTicket.getQuantity() * excursionTicket.getExcursion().getPrice());
        }else if (payMethod.equals("card")){
            strategy = new CreditCardStrategy();
            strategyStr = strategy.pay(excursionTicket.getQuantity() * excursionTicket.getExcursion().getPrice());
        }
        mv.setViewName("redirect:/tourist/tour/" + tourid + "?excursions");
        String message = "User \"" + tourist.getUsername() + " [ID: " + tourist.getId() +
                "]\" ordered " + quantity + " tickets for excursion \"" +
                excursion.getTitle() + " [ID:" + excursion.getId() + "]\". " + strategyStr +"\n";
        kafkaTemplate.send(TOPIC, message);
        return mv;
    }

    /**
     * Add me to event .
     *
     * @param eventid        the eventid
     * @param tourid         the tourid
     * @param authentication the authentication
     * @return the model and view
     */
    @PostMapping("/tourist/tour/{tourid}/event/{eventid}/addme")
    public ModelAndView addMeToEvent(@PathVariable Integer eventid, @PathVariable Integer tourid, Authentication authentication) {
        ModelAndView mv = new ModelAndView();
        Event event = evs.findEvent(eventid);
        us.addEvent((User) authentication.getPrincipal(), event);
        mv.setViewName("redirect:/tourist/tour/" + tourid + "?events");
        return mv;
    }
}
