package ru.romankrasinskij.stafftaskspace.controllers.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    @GetMapping("/workspace/calendar")
    public String showCalendarPage() {
        return "workspace/calendar-page";
    }
}
