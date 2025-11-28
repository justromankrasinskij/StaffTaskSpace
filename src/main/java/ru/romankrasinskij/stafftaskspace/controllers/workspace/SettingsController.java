package ru.romankrasinskij.stafftaskspace.controllers.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingsController {

    @GetMapping("/workspace/settings")
    public String showSettingsPage() {
        return "workspace/settings-page";
    }
}
