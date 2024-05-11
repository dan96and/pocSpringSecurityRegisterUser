package org.example.pocspringsecurityregisteruser.controller;

import org.example.pocspringsecurityregisteruser.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {
    //ApplicationController
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String requestMethodName() {
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage() {
        return "home";
    }
}
