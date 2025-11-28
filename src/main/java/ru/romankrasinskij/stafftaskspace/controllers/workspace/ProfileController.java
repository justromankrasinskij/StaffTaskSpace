package ru.romankrasinskij.stafftaskspace.controllers.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/workspace/profile")
    public String showProfilePage() {
        return "workspace/profile-page";
    }
}
