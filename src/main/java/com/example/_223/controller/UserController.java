package com.example._223.controller;

import com.example._223.model.User;
import com.example._223.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/loan")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers() {
        List<User> usersList = userService.getUsers();
        userService.saveAll(usersList);
        return "income";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "loan";
    }
}
