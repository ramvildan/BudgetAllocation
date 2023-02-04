package com.javamaster.application.converter;

import com.javamaster.application.dto.UsersDto;
import org.springframework.stereotype.Component;
import com.javamaster.application.entity.Users;

import static java.util.Objects.isNull;

@Component
public class UsersConverter {

    public Users fromUserDtoToUser(UsersDto usersDto) {
        if (isNull(usersDto)) {
            return null;
        }
        return Users.builder()
                .id(usersDto.getId())
                .email(usersDto.getEmail())
                .name(usersDto.getName())
                .login(usersDto.getLogin())
                .build();
    }

    public UsersDto fromUserToUserDto(Users users) {
        if (isNull(users)) {
            return null;
        }
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }
}
