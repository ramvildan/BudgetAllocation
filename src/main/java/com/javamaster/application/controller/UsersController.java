package com.javamaster.application.controller;

import com.javamaster.application.dto.UsersDto;
import com.javamaster.application.exception.ValidationException;
import com.javamaster.application.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/read-users")
    public String readAllUsers(Model model){
        model.addAttribute("users", usersService.findAll());
        log.info("Hanging read all users request");
        return "readusers";
    }

    @GetMapping("/save-user")
    public String showCreateUserPage(Model model){
        model.addAttribute("users", new UsersDto());
        return "createuser";
    }

    @PostMapping(value = "/save-user")
    public String createUser(@ModelAttribute("user") UsersDto usersDto) throws ValidationException{
        usersService.saveUser(usersDto);
        log.info("Handing save users: " + usersDto);
        return "redirect:/read-users";
    }

    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login){
        log.info("Handing find by login request: " + login);
        return usersService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id){
        log.info("Handing delete user request: " + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/update/{id}")
    public String showUpdateUserPage(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("users", usersService.findById(id));
        return "updateuser";
    }
    @PostMapping(value = "/update/{id}")
    public UsersDto updateUser(@PathVariable Integer id, @ModelAttribute("user") UsersDto usersDto){
        log.info("Handing update user by id: " + id);
        return usersService.updateUser(id, usersDto);
    }
}
