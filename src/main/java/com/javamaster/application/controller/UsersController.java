package com.javamaster.application.controller;

import com.javamaster.application.dto.UsersDto;
import com.javamaster.application.exception.ValidationException;
import com.javamaster.application.service.TransactionsService;
import com.javamaster.application.service.UsersService;
import com.javamaster.application.service.WalletsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Log
public class UsersController {
    private final UsersService usersService;

    private final WalletsService walletsService;

    @GetMapping("/read-users")
    public String readAllUsers(Model model){
        model.addAttribute("users", usersService.findAll());
        log.info("Hanging read all users request");
        return "readusers";
    }
    @GetMapping("/save-user")
    public String showCreateUserPage(Model model){
        model.addAttribute("user", new UsersDto());
        return "createuser";
    }
    @PostMapping(value = "/save-user")
    public String createUser(@ModelAttribute("user") UsersDto usersDto) throws ValidationException{
        log.info("Handing save users: " + usersDto);
        UsersDto savedUser = usersService.saveUser(usersDto);
        log.info("Handing read all users: " + savedUser);
        return "redirect:/users/read-users";
    }
    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login){
        log.info("Handing find by login request: " + login);
        return usersService.findByLogin(login);
    }
    @GetMapping("/delete/{id}")
    public String deleteUsers(@PathVariable Integer id){
        log.info("Handing delete user request: " + id);
        usersService.deleteUser(id);
        return "redirect:/users/read-users";
    }
    @GetMapping("/update/{id}")
    public String showUpdateUserPage(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("user", usersService.findById(id));
        return "updateuser";
    }
    @PostMapping(value = "/update/{id}")
    public String updateUser(@PathVariable Integer id, @ModelAttribute("user") UsersDto usersDto){
        log.info("Handing update user by id: " + id);
        log.info("Handing update user: " + usersDto);
        usersService.updateUser(id, usersDto);
        return "redirect:/users/read-users";
    }

    @GetMapping("/show/{id}")
    public String showUserInfo(@PathVariable Integer id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("user", usersService.findById(id));
        model.addAttribute("wallets", walletsService.getAllByUserId(id));
        return "showuser";
    }
}
