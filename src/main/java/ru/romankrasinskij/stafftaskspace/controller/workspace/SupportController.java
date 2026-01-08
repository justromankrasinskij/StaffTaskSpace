package ru.romankrasinskij.stafftaskspace.controller.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupportController {

    @GetMapping("/support")
    public String showSupportPage() {
        return "workspace/support-page";
    }
}
