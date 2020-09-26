package cz.cvut.fel.nss.tripguide.rest.admin;

import cz.cvut.fel.nss.tripguide.dto.DestinationDto;
import cz.cvut.fel.nss.tripguide.dto.LocalAttrDto;
import cz.cvut.fel.nss.tripguide.model.Destination;
import cz.cvut.fel.nss.tripguide.model.LocalAttraction;
import cz.cvut.fel.nss.tripguide.service.DestinationService;
import cz.cvut.fel.nss.tripguide.service.LocalAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * The class Destination controller.
 */
@RestController
public class DestinationController {

    private final DestinationService destinationService;
    private final LocalAttractionService laService;

    /**
     * Instantiates a new Destination controller.
     *
     * @param destinationService the destination service
     * @param laService          the local attraction service
     */
    @Autowired
    public DestinationController(DestinationService destinationService, LocalAttractionService laService) {
        this.destinationService = destinationService;
        this.laService = laService;
    }

    /**
     * Destination dto.
     *
     * @return the destination dto
     */
    @ModelAttribute("destination")
    public DestinationDto destinationDto() {
        return new DestinationDto();
    }

    /**
     * Local Attraction dto.
     *
     * @return the local attr dto
     */
    @ModelAttribute("attraction")
    public LocalAttrDto attrDto() {
        return new LocalAttrDto();
    }

    /**
     * Get all destinations.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping("/admin/dest")
    public ModelAndView getAllDestinationsAdmin(Model model) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("destinations", destinationService.getAllDestinations());
        mv.setViewName("admin/alldest");
        return mv;
    }

    /**
     * Get destination by id.
     *
     * @param model the model
     * @param id    the id
     * @return the model and view
     */
    @GetMapping("/admin/dest/{id}")
    public ModelAndView getDestinationAdmin(Model model, @PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("dest", destinationService.findDestination(id));
        mv.setViewName("admin/dest");
        return mv;
    }

    /**
     * Get all attractions by destination .
     *
     * @param id    the id
     * @param model the model
     * @return model and view
     */
    @GetMapping("/admin/dest/{id}/allattr")
    public ModelAndView getAllAttractionsByDestinationAdmin(@PathVariable Integer id, Model model) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("attractions", laService.getLocalAttractionsByDestination(destinationService.findDestination(id)));
        model.addAttribute("dest", destinationService.findDestination(id));
        mv.setViewName("admin/allattrsbydest");
        return mv;
    }

    /**
     * Gets hotels by destination.
     *
     * @param id    the id
     * @param model the model
     * @return model and view
     */
    @GetMapping("/admin/dest/{id}/hotels")
    public ModelAndView getHotelByDestinationAdmin(@PathVariable Integer id, Model model) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("hotels", destinationService.findDestination(id).getHotels());
        mv.setViewName("admin/desthotels");
        return mv;
    }

    /**
     * Add destination.
     *
     * @param dto the dto
     * @return the model and view
     */
    @PostMapping("/admin/dest/add")
    public ModelAndView addDestinationAdmin(@ModelAttribute("destination") @Valid DestinationDto dto) {
        ModelAndView mv = new ModelAndView();
        Destination destination = new Destination();
        destination.setName(dto.getName());
        destination.setCountry(dto.getCountry());
        destinationService.save(destination);
        mv.setViewName("redirect:/admin/dest");
        return mv;
    }

    /**
     * Add attraction.
     *
     * @param id  the id
     * @param dto the dto
     * @return the model and view
     */
    @PostMapping("/admin/dest/{id}/addattr")
    public ModelAndView addAttractionAdmin(@PathVariable Integer id, @ModelAttribute("attraction") @Valid LocalAttrDto dto) {
        ModelAndView mv = new ModelAndView();
        LocalAttraction attraction = new LocalAttraction();
        attraction.setName(dto.getName());
        attraction.setDescription(dto.getDescription());
        attraction.setAddress(dto.getAddress());
        attraction.setPrice(dto.getPrice());
        attraction.setPhotoUrl(dto.getPhotoUrl());
        attraction.setUrl(dto.getUrl());
        attraction.setDestination(destinationService.findDestination(id));
        laService.save(attraction);
        mv.setViewName("redirect:/admin/dest/" + id + "/allattr");
        return mv;
    }
}
