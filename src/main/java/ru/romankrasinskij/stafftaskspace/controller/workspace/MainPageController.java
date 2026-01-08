package ru.romankrasinskij.stafftaskspace.controller.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/workspace/main-page")
    public String showMainPage() {
        return "workspace/main-page";
    }
}
