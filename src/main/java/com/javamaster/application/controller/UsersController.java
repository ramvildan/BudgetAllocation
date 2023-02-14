package com.javamaster.application.controller;

import com.javamaster.application.dto.UsersDto;
import com.javamaster.application.exception.ValidationException;
import com.javamaster.application.service.UsersService;
import com.javamaster.application.service.WalletsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@Log4j2
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
        log.info("createUser: userDto = {}", usersDto);

        UsersDto savedUser = usersService.saveUser(usersDto);

        log.info("createUser: + savedUser = {}", savedUser);

        return "redirect:/users/read-users";
    }

    @GetMapping("/findByLogin")
    public UsersDto findByLogin(@RequestParam String login){
        log.info("findByLogin: login = {}", login);

        return usersService.findByLogin(login);
    }

    @GetMapping("/delete/{userId}")
    public String deleteUsers(@PathVariable Integer userId){
        log.info("deleteUsers: userId = {}", userId);

        usersService.deleteUser(userId);

        return "redirect:/users/read-users";
    }

    @GetMapping("/update/{userId}")
    public String showUpdateUserPage(@PathVariable Integer userId, Model model){

        model.addAttribute("id", userId);
        model.addAttribute("user", usersService.findById(userId));

        return "updateuser";
    }

    @PostMapping(value = "/update/{userId}")
    public String updateUser(@PathVariable Integer userId,
                             @ModelAttribute("user") UsersDto usersDto){
        log.info("updateUser: userId = {}, userDto = {}", userId, usersDto);

        usersService.updateUser(userId, usersDto);

        return "redirect:/users/read-users";
    }

    @GetMapping("/show/{userId}")
    public String showUserInfo(@PathVariable Integer userId, Model model){

        model.addAttribute("id", userId);
        model.addAttribute("user", usersService.findById(userId));
        model.addAttribute("wallets", walletsService.getAllByUserId(userId));

        return "showuser";
    }
}
