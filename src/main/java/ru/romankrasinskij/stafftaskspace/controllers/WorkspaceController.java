package ru.romankrasinskij.stafftaskspace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkspaceController {

    @GetMapping("/workspace")
    public String showWorkspacePage() {
        return "workspace-page";
    }
}
