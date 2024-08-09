package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServices;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userServices.getAllUsers());
        return "index";
    }

    @GetMapping("/show")
    public String getUserById(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userServices.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String createUserForm(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "new";
        userServices.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUserForm(@RequestParam int id, Model model) {
        model.addAttribute("user", userServices.getUserById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult, @RequestParam int id) {
        if (bindingResult.hasErrors())
            return "edit";
        userServices.updateUser(id, user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam int id) {
        userServices.deleteUser(id);
        return "redirect:/";
    }
}
