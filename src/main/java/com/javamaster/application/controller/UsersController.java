package com.javamaster.application.controller;

import com.javamaster.application.dto.UsersDto;
import com.javamaster.application.exception.ValidationException;
import com.javamaster.application.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Log
public class UsersController {

    private final UsersService usersService;

    @PostMapping(value = "/save")
    public UsersDto saveUsers(@RequestBody UsersDto usersDto) throws ValidationException{
        log.info("Handing save users: " + usersDto);
        return usersService.saveUser(usersDto);
    }

    @GetMapping("/findAll")
    public List<UsersDto> findAllUsers(){
        log.info("Hanging find all users request");
        return usersService.findAll();
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
}
