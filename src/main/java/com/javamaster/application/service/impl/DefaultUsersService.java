package com.javamaster.application.service.impl;

import com.javamaster.application.converter.UsersConverter;
import com.javamaster.application.dto.UsersDto;
import com.javamaster.application.entity.Wallet;
import com.javamaster.application.exception.ValidationException;
import com.javamaster.application.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.javamaster.application.entity.Users;
import com.javamaster.application.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class DefaultUsersService implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;

    private void validationUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validationUserDto(usersDto);
        Users entityToSave = usersConverter.fromUserDtoToUser(usersDto);
        Users savedUserWithWallet = usersRepository.save(entityToSave);
        savedUserWithWallet.setWallets(List.of(
                Wallet.builder().name("General Wallet").user(savedUserWithWallet).savePercent(50).build(),
                Wallet.builder().name("Investments").user(savedUserWithWallet).savePercent(10).build(),
                Wallet.builder().name("Treatment").savePercent(10).build(),
                Wallet.builder().name("Debts and gifts").user(savedUserWithWallet).savePercent(10).build(),
                Wallet.builder().name("Entertainment").user(savedUserWithWallet).savePercent(10).build(),
                Wallet.builder().name("Long term costs").user(savedUserWithWallet).savePercent(10).build()));
        Users savedUser = usersRepository.save(savedUserWithWallet);
        return usersConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto updateUser(Integer userId, UsersDto usersDto) {
        Users userToUpdate = usersRepository.findById(userId).orElse(null);
        userToUpdate.setLogin(usersDto.getLogin());
        userToUpdate.setName(usersDto.getName());
        userToUpdate.setEmail(usersDto.getEmail());
        Users updatedUser = usersRepository.save(userToUpdate);
        return usersConverter.fromUserToUserDto(updatedUser);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public UsersDto findById(Integer id) {
        Users user = usersRepository.findById(id).orElse(null);
        return usersConverter.fromUserToUserDto(user);
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll().stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
}
