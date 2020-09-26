package cz.cvut.fel.nss.tripguide.rest.admin;

import cz.cvut.fel.nss.tripguide.dto.NewUserDto;
import cz.cvut.fel.nss.tripguide.model.Role;
import cz.cvut.fel.nss.tripguide.model.User;
import cz.cvut.fel.nss.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;

/**
 * The class User controller.
 */
@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    /**
     * User dto.
     *
     * @return the new user dto
     */
    @ModelAttribute("user")
    public NewUserDto userDto() {
        return new NewUserDto();
    }

    /**
     * Instantiates a new User controller.
     *
     * @param userService     the user service
     * @param passwordEncoder the password encoder
     */
    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Get all users.
     *
     * @param model the model
     * @return the model and view
     */
    @GetMapping("/admin/users")
    public ModelAndView getAllUsers(Model model) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("tourists", userService.getAllUsers());
        mv.setViewName("admin/allusers");
        return mv;
    }

    /**
     * Get users by role.
     *
     * @param model the model
     * @param role  the role
     * @return the model and view
     */
    @GetMapping("/admin/users/filter/{role}")
    public ModelAndView getUsersByRole(Model model, @PathVariable String role) {
        ModelAndView mv = new ModelAndView();
        switch (role) {
            case "admins":
                model.addAttribute("tourists", userService.getTouristsByRole(Role.ADMIN));
                break;
            case "delegates":
                model.addAttribute("tourists", userService.getTouristsByRole(Role.DELEGATE));
                break;
            case "tourists":
                model.addAttribute("tourists", userService.getTouristsByRole(Role.TOURIST));
                break;
        }
        mv.setViewName("admin/allusers");
        return mv;
    }

    /**
     * Gets user info.
     *
     * @param model the model
     * @param id    the id
     * @return the user info
     */
    @GetMapping("/admin/users/{id}")
    public ModelAndView getUserInfo(Model model, @PathVariable Integer id) {
        ModelAndView mv = new ModelAndView();
        model.addAttribute("user", userService.findUser(id));
        mv.setViewName("admin/user");
        return mv;
    }

    /**
     * Create user.
     *
     * @param dto the dto
     * @return the model and view
     */
    @PostMapping("/admin/users/add")
    public ModelAndView createUser(@ModelAttribute("user") @Valid NewUserDto dto) {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        switch (dto.getRole()) {
            case "Tourist":
                user.setRoles(Collections.singleton(Role.TOURIST));
                break;
            case "Delegate":
                user.setRoles(Collections.singleton(Role.DELEGATE));
                break;
            case "Admin":
                user.setRoles(Collections.singleton(Role.ADMIN));
                break;
        }
        user.setUsername(dto.getUsername());
        user.setPhoneNumber(dto.getPhoneNumber());
        userService.save(user);
        mv.setViewName("redirect:/admin/users");
        return mv;
    }
}
