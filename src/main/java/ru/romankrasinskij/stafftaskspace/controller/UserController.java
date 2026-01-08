package ru.romankrasinskij.stafftaskspace.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.romankrasinskij.stafftaskspace.dto.UserDto;
import ru.romankrasinskij.stafftaskspace.entity.User;
import ru.romankrasinskij.stafftaskspace.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute UserDto userDto) {
        User user = userService.toUser(userDto);
        userService.save(user);

        return "redirect:/workspace";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute UserDto userDto, Principal principal) {
        String username = principal.getName();
        User userFromDatabase = userService.findByUsername(username);

        User userFromDto = userService.toUser(userDto);
        long id = userFromDatabase.getId();

        userService.update(id, userFromDto);

        return "redirect:/login";
    }
}
