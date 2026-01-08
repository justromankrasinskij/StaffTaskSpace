package ru.romankrasinskij.stafftaskspace.controller.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingsController {

    @GetMapping("/settings")
    public String showSettingsPage() {
        return "workspace/settings-page";
    }
}
