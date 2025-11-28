package ru.romankrasinskij.stafftaskspace.controllers.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TasksController {

    @GetMapping("/workspace/tasks")
    public String showTasksPage() {
        return "workspace/tasks-page";
    }
}
