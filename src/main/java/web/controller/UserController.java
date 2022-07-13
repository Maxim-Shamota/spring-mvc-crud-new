package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "redirect:/users";
    }

    @GetMapping(value = "users")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping(value = "users/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/edit/{id}")
    public String edit(ModelMap model, @PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "users/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/show/{id}")
    public String showUser(ModelMap model, @PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "show";
    }

    @GetMapping("users/delete")
    public String deleteUserById(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
