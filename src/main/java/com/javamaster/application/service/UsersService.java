package com.javamaster.application.service;

import com.javamaster.application.dto.UsersDto;
import com.javamaster.application.exception.ValidationException;

import java.util.List;

public interface UsersService {

    UsersDto saveUser(UsersDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();

}
