package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.models.User;
import web.services.UserServices;


@Controller
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userServices.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userServices.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userServices.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServices.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")  User user, @PathVariable("id") int id) {
        userServices.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userServices.delete(id);
        return "redirect:/";
    }
}
