package com.javamaster.application.service;

import com.javamaster.application.dto.UsersDto;
import com.javamaster.application.exception.ValidationException;

import java.util.List;

public interface UsersService {

    UsersDto saveUser(UsersDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDto updateUser(Integer userId, UsersDto usersDto);

    UsersDto findByLogin(String login);

    UsersDto findById(Integer id);

    List<UsersDto> findAll();

}
