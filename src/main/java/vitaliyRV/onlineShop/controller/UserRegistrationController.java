package vitaliyRV.onlineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vitaliyRV.onlineShop.entity.User;
import vitaliyRV.onlineShop.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid User user, BindingResult result){
        User existing = userService.findByUsername(user.getUsername());
        if (existing != null){
            result.rejectValue("username", null, "There is already an account registered with that name");
        }

        if (result.hasErrors()){
            return "registration";
        }

        userService.save(user);
        return "redirect:/registration?success";
    }
}
