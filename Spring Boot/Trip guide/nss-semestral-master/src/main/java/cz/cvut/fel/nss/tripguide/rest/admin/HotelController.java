package cz.cvut.fel.nss.tripguide.rest.admin;

import cz.cvut.fel.nss.tripguide.dto.HotelDto;
import cz.cvut.fel.nss.tripguide.model.Hotel;
import cz.cvut.fel.nss.tripguide.service.DestinationService;
import cz.cvut.fel.nss.tripguide.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * The class Hotel controller.
 */
@RestController
public class HotelController {

    private final HotelService hotelService;
    private final DestinationService destinationService;

    /**
     * Hotel dto.
     *
     * @return the new hotel dto
     */
    @ModelAttribute("hotel")
    public HotelDto hotelDto() {
        return new HotelDto();
    }

    /**
     * Instantiates a new Hotel controller.
     *
     * @param hotelService       the hotel service
     * @param destinationService the destination service
     */
    @Autowired
    public HotelController(HotelService hotelService, DestinationService destinationService) {
        this.hotelService = hotelService;
        this.destinationService = destinationService;
    }

    /**
     * Get all hotels.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping("/admin/hotels")
    public ModelAndView getAllHotels(Model model) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("destinations", destinationService.getAllDestinationsByName());
        model.addAttribute("hotels", hotelService.getAllHotels());
        mv.setViewName("admin/allhotels");
        return mv;
    }

    /**
     * Get hotel by id.
     *
     * @param model the model
     * @param id    the id
     * @return the model and view
     */
    @GetMapping("/admin/hotels/{id}")
    public ModelAndView getHotel(Model model, @PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("hotel", hotelService.findHotel(id));
        mv.setViewName("admin/hotel");
        return mv;
    }

    /**
     * Gets add hotel page.
     *
     * @return the add hotel page
     */
    @GetMapping("/admin/hotels/add")
    public ModelAndView getAddHotelPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/createhotel");
        return mv;
    }

    /**
     * Add hotel.
     *
     * @param dto the dto
     * @return the model and view
     */
    @PostMapping("/admin/hotels/add")
    public ModelAndView addHotel(@ModelAttribute("hotel") @Valid HotelDto dto) {
        ModelAndView mv = new ModelAndView();
        Hotel hotel = new Hotel();
        hotel.setName(dto.getName());
        hotel.setStars(Integer.parseInt(dto.getStars()));
        hotel.setAddress(dto.getAddress());
        hotel.setEmail(dto.getEmail());
        hotel.setPhoneNumber(dto.getPhoneNumbrer());
        hotel.setWeb(dto.getWeb());
        hotel.setMealServiceInfo(dto.getMealServiceInfo());
        hotel.setDestination(destinationService.findDestination(dto.getDestination()));
        hotelService.save(hotel);
        mv.setViewName("redirect:/admin/hotels");
        return mv;
    }


}
