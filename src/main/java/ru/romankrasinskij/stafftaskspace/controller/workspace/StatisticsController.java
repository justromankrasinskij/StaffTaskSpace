package ru.romankrasinskij.stafftaskspace.controller.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    @GetMapping("/workspace/statistics")
    public String showStatisticsPage() {
        return "workspace/statistics-page";
    }
}
