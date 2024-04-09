package org.example.pocspringsecurityregisteruser.controller;

import lombok.RequiredArgsConstructor;
import org.example.pocspringsecurityregisteruser.domain.User;
import org.example.pocspringsecurityregisteruser.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create-user")
    public String createUser(@RequestBody User user, RedirectAttributes redirectAttributes) {
        userService.createUser(user);
        redirectAttributes.addFlashAttribute("message", "Te has registrado correctamente");
        return "redirect:/login";
    }
}
