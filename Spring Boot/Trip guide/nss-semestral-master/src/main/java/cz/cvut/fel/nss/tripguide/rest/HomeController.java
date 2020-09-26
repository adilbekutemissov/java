package cz.cvut.fel.nss.tripguide.rest;

import cz.cvut.fel.nss.tripguide.model.Role;
import cz.cvut.fel.nss.tripguide.model.User;
import cz.cvut.fel.nss.tripguide.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * The class Home controller.
 */
@RestController
public class HomeController {

    private final TourService tourService;

    /**
     * Instantiates a new Home controller.
     *
     * @param tourService the tour service
     */
    @Autowired
    public HomeController(TourService tourService) {
        this.tourService = tourService;
    }

    /**
     * gets Home page.
     *
     * @param model          the model
     * @param authentication the authentication
     * @return the model and view
     */
    @GetMapping({"", "/"})
    public ModelAndView home(Model model, Authentication authentication) {
        ModelAndView mv = new ModelAndView();
        if (authentication == null) {
            mv.setViewName("redirect:/login");
        } else {
            if (authentication.getAuthorities().contains(Role.ADMIN)) {
                mv.setViewName("admin/index");
            } else if (authentication.getAuthorities().contains(Role.DELEGATE)) {
                mv.setViewName("delegate/index");
            } else if (authentication.getAuthorities().contains(Role.TOURIST)) {
                mv.setViewName("tourist/index");
            }
        }
        return mv;
    }

    /**
     * gets Delegate home
     *
     * @param model          the model
     * @param authentication the authentication
     * @return the model and view
     */
    @GetMapping("/delegate/home")
    public ModelAndView delegateHome(Model model, Authentication authentication) {
        ModelAndView mv = new ModelAndView();
        User delegate = (User) authentication.getPrincipal();
        model.addAttribute("tours", tourService.findToursByDelegate(delegate));
        mv.setViewName("delegate/index");
        return mv;
    }

    /**
     * gets Admin home page.
     *
     * @return the model and view
     */
    @GetMapping("/admin/home")
    public ModelAndView adminHome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/index");
        return mv;
    }

    /**
     * gets Tourist home page.
     *
     * @param model          the model
     * @param authentication the authentication
     * @return the model and view
     */
    @GetMapping("/tourist/home")
    public ModelAndView touristHome(Model model, Authentication authentication) {
        ModelAndView mv = new ModelAndView();
        User tourist = (User) authentication.getPrincipal();
        model.addAttribute("tourist", (User) authentication.getPrincipal());
        model.addAttribute("tours", tourService.findToursByTourist(tourist));
        mv.setViewName("tourist/index");
        return mv;
    }
}
