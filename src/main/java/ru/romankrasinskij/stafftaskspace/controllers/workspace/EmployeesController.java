package ru.romankrasinskij.stafftaskspace.controllers.workspace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeesController {

    @GetMapping("/workspace/employees")
    public String showEmployeesPage() {
        return "workspace/employees-page";
    }
}
