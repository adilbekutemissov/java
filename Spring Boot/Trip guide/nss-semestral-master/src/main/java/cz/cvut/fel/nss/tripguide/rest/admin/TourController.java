package cz.cvut.fel.nss.tripguide.rest.admin;

import cz.cvut.fel.nss.tripguide.dto.ExcursionDto;
import cz.cvut.fel.nss.tripguide.dto.TourDto;
import cz.cvut.fel.nss.tripguide.model.Excursion;
import cz.cvut.fel.nss.tripguide.model.Tour;
import cz.cvut.fel.nss.tripguide.model.User;
import cz.cvut.fel.nss.tripguide.service.ExcursionService;
import cz.cvut.fel.nss.tripguide.service.HotelService;
import cz.cvut.fel.nss.tripguide.service.TourService;
import cz.cvut.fel.nss.tripguide.service.UserService;
import cz.cvut.fel.nss.tripguide.util.iterators.TourIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * The class Tour controller.
 */
@RestController
public class TourController {

    private final TourService tourService;
    private final UserService userService;
    private final HotelService hotelService;
    private final ExcursionService excursionService;

    /**
     * Tour dto.
     *
     * @return the new tour dto
     */
    @ModelAttribute("tour")
    public TourDto tourDto() {
        return new TourDto();
    }

    /**
     * Excursion dto.
     *
     * @return the new excursion dto
     */
    @ModelAttribute("excursion")
    public ExcursionDto excursionDto() {
        return new ExcursionDto();
    }

    /**
     * Instantiates a new Tour controller.
     *
     * @param tourService      the tour service
     * @param userService      the user service
     * @param hotelService     the hotel service
     * @param excursionService the excursion service
     */
    @Autowired
    public TourController(TourService tourService, UserService userService, HotelService hotelService, ExcursionService excursionService) {
        this.tourService = tourService;
        this.userService = userService;
        this.hotelService = hotelService;
        this.excursionService = excursionService;
    }

    /**
     * Get all tours.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping("/admin/tours")
    public ModelAndView getAllTours(Model model) {
        ModelAndView mv = new ModelAndView();
        TourIterator ti = new TourIterator(tourService.getAllTours());
        Set<Tour> tourSet = new HashSet<>();
        while (ti.hasNext()) {
            Tour tour = ti.getNext();
            tourSet.add(tour);
        }
        model.addAttribute("tours", tourSet);
        model.addAttribute("hotels", hotelService.getAllHotelsByName());
        mv.setViewName("admin/alltours");
        return mv;
    }

    /**
     * Get tour.
     *
     * @param model the model
     * @param id    the id
     * @return the model and view
     */
    @GetMapping("/admin/tours/{id}")
    public ModelAndView getTour(Model model, @PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        Tour tour = tourService.findTour(id);
        model.addAttribute("tour", tour);
        model.addAttribute("tourists", userService.getTouristsByTour(tour));
        mv.setViewName("admin/tour");
        return mv;
    }

    /**
     * Gets add tour page.
     *
     * @return the add tour page
     */
    @GetMapping("/admin/tours/add")
    public ModelAndView getAddTourPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/createtour");
        return mv;
    }

    /**
     * Add tour.
     *
     * @param dto the dto
     * @return the model and view
     */
    @PostMapping("/admin/tours/add")
    public ModelAndView addTour(@ModelAttribute("tour") @Valid TourDto dto) {
        ModelAndView mv = new ModelAndView();
        Tour tour = new Tour();
        tour.setTitle(dto.getTitle());
        tour.setStart(LocalDate.parse(dto.getStart()));
        tour.setEnd(LocalDate.parse(dto.getEnd()));
        tour.setBackTransferInfo(dto.getBackTransferInfo());
        tour.setDelegate(userService.findUser(dto.getDelegate()));
        tour.setHotel(hotelService.findHotel(dto.getHotel()));
        tourService.save(tour);
        mv.setViewName("redirect:/admin/tours");
        return mv;
    }

    /**
     * Add tourist to tour.
     *
     * @param model    the model
     * @param tourid   the tourid
     * @param username the username
     * @return the model and view
     */
    @PostMapping("/admin/tours/{tourid}/tourists")
    public ModelAndView addTouristToTour(Model model, @PathVariable Integer tourid, @RequestParam String username) {
        ModelAndView mv = new ModelAndView();
        User user = userService.findUser(username);
        Tour tour = tourService.findTour(tourid);
        tour.addUser(user);
        tour = tourService.save(tour);
        user = userService.addTour(user, tour);
        model.addAttribute("tourid", tourid);
        mv.setViewName("redirect:/admin/tours/" + tourid + "?tourists");
        return mv;
    }

    /**
     * Get excursions by tour.
     *
     * @param model the model
     * @param id    the id
     * @return the model and view
     */
    @GetMapping("/admin/tours/{id}/excursions")
    public ModelAndView getExcursionsByTour(Model model, @PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("excursions", excursionService.findExcursionsByTour(tourService.findTour(id)));
        model.addAttribute("tour", tourService.findTour(id));
        mv.setViewName("admin/allexcursionsbytour");
        return mv;
    }

    /**
     * Add new excursions to tour.
     *
     * @param id  the id
     * @param dto the dto
     * @return the model and view
     */
    @PostMapping("/admin/tours/{id}/addexc")
    public ModelAndView addNewExcursionsToTour(@PathVariable Integer id, @ModelAttribute("excursion") @Valid ExcursionDto dto) {
        ModelAndView mv = new ModelAndView();
        Excursion excursion = new Excursion();
        excursion.setTitle(dto.getTitle());
        excursion.setDescription(dto.getDescription());
        excursion.setPrice(Integer.parseInt(dto.getPrice()));
        excursion.setStart(LocalDateTime.parse(dto.getStart()));
        excursion.setEnd(LocalDateTime.parse(dto.getEnd()));
        excursion.setMeetingLocation(dto.getMeetingLocation());
        excursion.setTour(tourService.findTour(id));
        excursionService.addExcursion(excursion);
        mv.setViewName("redirect:/admin/tours/"+id+"/excursions");
        return mv;
    }
}
