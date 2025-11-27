package ru.romankrasinskij.stafftaskspace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.romankrasinskij.stafftaskspace.dto.RegistrationDto;
import ru.romankrasinskij.stafftaskspace.models.User;
import ru.romankrasinskij.stafftaskspace.services.RegistrationService;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration-form";
    }

    @PostMapping("/submit-registration-form")
    public String saveUser(@ModelAttribute RegistrationDto registrationDto) {
        User user = registrationService.toUser(registrationDto);
        registrationService.save(user);

        return "redirect:/";
    }
}
