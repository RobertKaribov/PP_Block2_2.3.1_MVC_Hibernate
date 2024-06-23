package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
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
    public String index(Model model) {
        model.addAttribute("users", userServices.index());
        return "index";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userServices.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "new";
        userServices.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("user", userServices.show(id));
        return "edit";
    }

    @PostMapping ("/update")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, @RequestParam int id) {
        if (bindingResult.hasErrors())
            return "edit";
        userServices.update(id, user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        userServices.delete(id);
        return "redirect:/";
    }
}

