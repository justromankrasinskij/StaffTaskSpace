package ru.romankrasinskij.stafftaskspace.controller.workspace;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.romankrasinskij.stafftaskspace.entity.User;
import ru.romankrasinskij.stafftaskspace.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService registrationService;

    public ProfileController(UserService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String showProfilePage(Principal principal, Model model) {
        User user = registrationService.findByUsername(principal.getName());

        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("patronymic", user.getPatronymic());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phoneNumber", user.getPhoneNumber());
        model.addAttribute("telegramUsername", user.getTelegramUsername());
        model.addAttribute("company", user.getCompany());
        model.addAttribute("dateOfBirth", user.getDateOfBirth());
        model.addAttribute("appointment", user.getAppointment());
        model.addAttribute("department", user.getDepartment());

        return "workspace/profile-page";
    }
}
